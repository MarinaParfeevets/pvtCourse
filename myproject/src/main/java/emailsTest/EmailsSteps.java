package emailsTest;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import baseInitial.WebDriverSingleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataBaseConnect.UserDataTable;
import interfaces.IInitial;
import parserEmail.NewEmailInfo;
import parserEmail.NewEmailInfoSaxParser;
import ru.yandex.qatools.allure.annotations.Attachment;
import screenShotsReport.ScreenShot;

public class EmailsSteps implements IInitial {
	private LoginPage loginPage;
	private EmailsPage emails;
	private UserDataTable userDataTable;
	private NewLetterPage newLetterPage;
	private NewEmailInfo newEmailInfo;
	private WebDriver driver;
	private static String textOfLetter;
	private static final Logger log = Logger.getLogger(EmailsSteps.class);

	public EmailsSteps() {
		driver = WebDriverSingleton.getDriver();
		loginPage = new LoginPage(driver);
		emails = new EmailsPage(driver);
		loginPage.setInitialProperty();
		newLetterPage = new NewLetterPage(driver);
		log.info("Page initialization finished");
		userDataTable = new UserDataTable();
		try {
			userDataTable.setUserLoginPasswordFromDB();
		} catch (SQLException e) {
			log.fatal(e.getMessage());
			log.trace(e.getStackTrace());
		}
		log.info("DataBase initialization is finished");
	}

	@Before("@sendNewEmail")
	public void getEmailInfoFromXml() {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			NewEmailInfoSaxParser saxParserObject = new NewEmailInfoSaxParser();
			saxParser.parse(new File(NEW_EMAIL_INFO_XML), saxParserObject);
			newEmailInfo = saxParserObject.getEmailInfo().get(0);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			log.error(e.getMessage());
			this.createAttachment(Arrays.toString(e.getStackTrace()));
		}
		log.info("Email's Data was successfully read from NEW_EMAIL_INFO_XML.xml");
	}

	@Given("^Main application page is opened$")
	public void loadMainPage() {
		driver.get(MAIN_URL);
		log.info("Main application page is loaded");
	}

	@When("^Open new email form$")
	public void openNewEmailForm() {
		newLetterPage.writeNewEmail();
		log.info("New email form is opened");
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^Input data to emails$")
	public void inputDatatoEmail() {
		newLetterPage.createLetter(newEmailInfo);
		log.info("Receiver, subject, text of email are inputed");
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^Click  Send email$")
	public void clickSendButton() {
		newLetterPage.sendLetter();
		log.info("Email was sent");
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^Email is sent$")
	public void isEmailsent() {
		boolean check = newLetterPage.checkIsMessageSent();
		Assert.assertTrue(check);
		if (check) {
			log.info("Email was sent successfully");
		} else {
			log.warn("Email wasn't sent!");
		}
	}

	@When("^Enter correct user login and password$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPass(userDataTable.getUserLogin(), userDataTable.getUserPassword());
		loginPage.clickEnterButton();
		log.info("Enter with correct login and password");
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^Logout link is displayed$")
	public void seeLogoutLink() {
		boolean check = loginPage.logoutLinkPresents();
		if (check) {
			log.info("Logout link validation successful");
		} else {
			log.error("Logout link validation failed");
		}
		Assert.assertTrue(check);
	}

	@When("^Click \"([^\"]*)\" folder link$")
	public void clickFolderLink(String folder) {
		if (folder.equals("incomming")) {
			emails.clickIncomming();
		} else if (folder.equals("spam")) {
			emails.clickSpam();
		} else {
			log.fatal("No functionality realization!! Code is absent for " + folder + " link!");
		}
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^Select email's checkbox by (\\d+) index$")
	public void checkEmailByIndex(int index) {
		try {
			emails.selectEmailByIndex(index);
			textOfLetter = emails.getEmailTextByIndex(index);
		} catch (IndexOutOfBoundsException e) {
			log.error(e.getMessage());
			this.createAttachment(Arrays.toString(e.getStackTrace()));
		}
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^Click \"([^\"]*)\" button$")
	public void clickSpamButtons(String spamBut) {
		if (spamBut.equals("spam")) {
			emails.clickSpamButtom();
		} else if (spamBut.equals("noSpam")) {
			emails.clickNoSpamButtom();
		} else {
			log.fatal("Realisation of " + spamBut + " click is absent!");
		}
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^Email disappeared from \"([^\"]*)\" folder$")
	public void isEmailDisappearedFromFolder(String folder) {
		String alert = "";
		if (folder.equals("incomming")) {
			alert = "After moving to the folder 'Spam', the Email did not disappear from the folder 'Incomming'";
		} else if (folder.equals("spam")) {
			alert = "The Email did not disappear from the folder 'Spam' after restoring!";
		} else {
			log.fatal("No functionality realization!! Code is absent for " + folder + " link!");
		}
		boolean check = emails.isEmailWithTextInList(textOfLetter);
		if (!check) {
			log.info("Email disappeared from " + folder + " folder");
		} else {
			log.error("Email is not disappeared from " + folder + " folder");
		}
		Assert.assertFalse(alert, check);
	}

	@And("^Appear message about relocated email to \"([^\"]*)\" folder$")
	public void isPresentMessageAboutRelocatedEmail(String toFolder) {
		Assert.assertTrue(emails.isPresentMessageAboutRelocatedEmail(toFolder));

	}

	@When("^Mark email's flags$")
	public void markEmailsFlags() {
		try {
			emails.pressFlagKey();
		} catch (AWTException ex) {
			log.error(ex.getMessage());
			this.createAttachment(Arrays.toString(ex.getStackTrace()));
		}
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^Select all checkboxes$")
	public void selectAllEmails() {
		emails.selectAllEmails();
		log.info("All emails are selected");
		try {
			ScreenShot.makeScreenShot(driver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^All email's are marked with flag$")
	public void allEmailsMarkedWithFlags() {
		boolean check = emails.AreAllEmailsSelectedFlag();
		if (check) {
			log.info("All emails are marked with flag");
		} else {
			log.error("Not all emails are marked with flag");
		}
		Assert.assertTrue(check);
	}

	@Then("^All email's flag are removed$")
	public void allEmailsFlagsRemoved() {
		boolean check = emails.noFlagedEmailsInList();
		if (check) {
			log.info("All emails flags are removed");
		} else {
			log.error("Flags removed with error");
		}
		Assert.assertTrue(emails.noFlagedEmailsInList());
	}

	@After("@removeFlagToAllEmails")
	public void afterClass() {
		WebDriverSingleton.quitDriver();
	}

	@Attachment()
	private byte[] createAttachment(String att) {
		String content = att;
		return content.getBytes();
	}
}

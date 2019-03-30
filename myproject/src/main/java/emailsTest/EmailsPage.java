package emailsTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseInitial.InitialPage;

public class EmailsPage extends InitialPage {
	private Robot robot;
	@FindBy(xpath = ".//div[@id='b-nav_folders']//span[text()='Входящие']")
	private WebElement incommingLink;
	@FindBy(xpath = ".//div[@id='b-nav_folders']//span[text()='Спам']")
	private WebElement spamLink;
	@FindBy(xpath = ".//div[@class='b-datalist__item__subj' and not(ancestor::div[contains(@style, 'display: none;')])]")
	private List<WebElement> emails;
	@FindBy(xpath = "(//div[contains(@class,'checkbox__box') and ancestor::div[@id='b-letters']and not(ancestor::div[contains(@style, 'display: none;')])])")
	private List<WebElement> lettersCheckBoxes;
	@FindBy(xpath = "(.//div[@data-name='spam'])[1]")
	private WebElement spamButton;
	@FindBy(xpath = ".//span[contains(text(),'в папку «Спам».')]")
	public WebElement relocateToSpamMessage;
	@FindBy(xpath = ".//span[contains(text(),'в папку «Входящие»')]")
	public WebElement relocateFromSpamToIncommingMessage;
	@FindBy(xpath = "(.//div[@class='b-dropdown__ctrl js-shortcut'])[6]")
	private WebElement moreDropdown;
	@FindBy(xpath = ".//div[@data-bem='b-flag']")
	private List<WebElement> flag;
	@FindBy(xpath = ".//div[@data-bem='b-datalist__item']")
	private List<WebElement> lettersInSpam;
	@FindBy(xpath = ".//div[@class='js-item-checkbox b-datalist__item__cbx']")
	private List<WebElement> lettersInSpamCheckBoxes;
	@FindBy(xpath = "(.//div[@data-name='noSpam'])[1]")
	private WebElement notSpamButton;
	@FindBy(xpath = "(.//div[contains(@class, 'b-checkbox__box')])[1]")
	public WebElement selectAllEmails;
	private WebElement markFlag;

	public EmailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getLetters() {
		return emails;
	}

	public void clickIncomming() {
		wait.until(ExpectedConditions.visibilityOf(incommingLink));
		incommingLink.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(lettersCheckBoxes));
	}

	public void clickSpam() {
		wait.until(ExpectedConditions.visibilityOf(spamLink));
		spamLink.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(lettersCheckBoxes));
	}

	public List<WebElement> getListOfLetters() {
		return emails;
	}

	public boolean isListOfLetterEmpty() {
		return emails.isEmpty();
	}

	public String getEmailTextByIndex(int index) {
		String text = null;
		try {
			emails.get(index).getText();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return text;
	}

	public void selectEmailByIndex(int index) {
		if (!isListOfLetterEmpty()) {
			lettersCheckBoxes.get(index).click();
		}
	}

	public void clickSpamButtom() {
		spamButton.click();
		wait.until(ExpectedConditions.visibilityOf(relocateToSpamMessage));
	}

	public void clickNoSpamButtom() {
		notSpamButton.click();
		wait.until(ExpectedConditions.visibilityOf(relocateFromSpamToIncommingMessage));
	}

	public boolean isPresentMessageAboutRelocatedEmail(String toFolder) {
		if (toFolder.contains("spam")) {
			wait.until(ExpectedConditions.visibilityOf(relocateToSpamMessage));
			return relocateToSpamMessage.isDisplayed();
		}
		if (toFolder.contains("incomming")) {
			wait.until(ExpectedConditions.visibilityOf(relocateFromSpamToIncommingMessage));
			return relocateFromSpamToIncommingMessage.isDisplayed();
		} else {
			return false;
		}
	}

	public boolean isEmailWithTextInList(String text) {
		for (WebElement el : emails) {
			if (el.getText() == text) {
				return true;
			}
		}
		return false;
	}

	public void pressFlagKey() throws AWTException {
		try {
			robot = new Robot();
			robot.keyPress(73);
			robot.keyRelease(73);
		} catch (AWTException ex) {
			throw ex;
		}
	}

	public void selectAllEmails() {
		selectAllEmails.click();
	}

	public boolean noFlagedEmailsInList() {
		for (int i = 0; i < flag.size(); i++) {
			markFlag = flag.get(i);
			if (markFlag.getAttribute("title").equals("Снять флажок")) {
				return false;
			}
		}
		return true;
	}

	public boolean AreAllEmailsSelectedFlag() {
		for (int i = 0; i < flag.size(); i++) {
			markFlag = flag.get(i);
			if (markFlag.getAttribute("title").equals("Пометить флажком")) {
				return false;
			}
		}
		return true;
	}
}

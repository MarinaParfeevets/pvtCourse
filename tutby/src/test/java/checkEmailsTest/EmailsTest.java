package checkEmailsTest;

import org.testng.annotations.Test;

import checkEmails.Emails;
import checkEmails.Initial;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailsTest {
	private WebDriver driver;
	private static final String MAIN_URL = "http://tut.by";
	public static final int TIMEOUT = 20;
	private Initial initialPage;
	private Emails emailsPage;
	private static final Logger log = Logger.getLogger(EmailsTest.class);

	@Parameters({ "log", "passw" })
	@Test(timeOut = 20000)
	public void checkCountOfEmails(String login, String password) {
		initialPage.logInAccount(login, password);
		log.info("2. Autorization with correct login and password.");
		initialPage.goToMailBox();
		log.info("3. Emails box is loaded.");
		boolean isListEmpty = emailsPage.isListOfEmailsEmpty();
		Assert.assertFalse(isListEmpty);
		if (isListEmpty) {
			log.warn("4. Inbox is empty. ");
		} else {
			log.info("4. There are " + emailsPage.countOfEmailsInInBox() + " emails in inbox. ");
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		initialPage = new Initial(driver);
		emailsPage = new Emails(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@BeforeClass
	public void beforeClass() {
		driver.get(MAIN_URL);
		log.info("1. Main application page tut.by is loaded.");
		(new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("authorize")));
		driver.manage().window().maximize();
	}

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}

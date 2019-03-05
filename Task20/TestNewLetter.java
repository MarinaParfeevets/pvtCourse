package core;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CreateNewLetterInfo;
import Pages.IncommingLetters;
import Pages.LoginPage;
import Pages.NewLetterPage;

public class TestNewLetter {

	private WebDriver driver;
	private LoginPage loginPage;
	private NewLetterPage newLetterPage;
	private IncommingLetters incommingLetters;
	private CreateNewLetterInfo createNewLetterInfo;
	private String recievers;
	private String subject;
	private String textOfLetter;

	@BeforeClass
	public static void setUpBeforeClass() {

	}

	@AfterClass
	public static void tearDownAfterClass() {

	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.mail.ru/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testSendNewLetter() {
		loginPage = new LoginPage(driver);
		newLetterPage = new NewLetterPage(driver);
		incommingLetters = new IncommingLetters(driver);
		loginPage.enterData("parfeevets.marina", "automationCourse");
		loginPage.clickEnterButton();
		recievers = "marisha_87@tut.by, test@mail.ru";
		subject = "Testing letter...";
		textOfLetter = " Hello, my friend! How are you?!";
		createNewLetterInfo = new CreateNewLetterInfo(recievers, subject, textOfLetter);
		incommingLetters.writeNewLetter();
		newLetterPage.createLetter(createNewLetterInfo, driver);
		newLetterPage.sendLetter();
		Assert.assertTrue(newLetterPage.checkIsMessageSent());
	}
}

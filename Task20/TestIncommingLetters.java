package core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.IncommingLetters;
import Pages.LoginPage;
import Pages.SpamLetters;

public class TestIncommingLetters {
	private WebDriver driver;
	private LoginPage loginPage;
	private SpamLetters spamLetters;
	private IncommingLetters incommingLetters;

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
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testRelocateTofolders() {
		loginPage = new LoginPage(driver);
		incommingLetters = new IncommingLetters(driver);
		spamLetters = new SpamLetters(driver);
		loginPage.enterData("parfeevets.marina", "automationCourse");
		loginPage.clickEnterButton();
		new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Входящие"));
		incommingLetters.clickIncomming();
		// remove to spam folder
		String letterFromIncommingToSpam = incommingLetters.textLetterWhichRelocatedToSpamByIndex(3);
		Assert.assertTrue("After moving to the folder 'Spam', the letter did not disappear from the folder 'Incomming'",
				incommingLetters.isLetterWithTextInList(letterFromIncommingToSpam));
		incommingLetters.clickSpam(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Спам"));
		Assert.assertTrue("The letter is absent in folder 'Spam' after clicking 'Spam'buttom in folder 'Incomming'",
				spamLetters.isLetterWithTextInList(letterFromIncommingToSpam));
		// restore from spam folder
		String letterRestoreFromSpam = spamLetters.textLetterToResroteFromSpamByIndex(0);
		Assert.assertTrue("The letter did not disappear from the folder 'Spam' after restoring! ",
				spamLetters.isLetterWithTextInList(letterRestoreFromSpam));
		spamLetters.clickIncomming(driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Входящие"));
		Assert.assertTrue("The letter is absent in folder 'Incomming'",
				incommingLetters.isLetterWithTextInList(letterRestoreFromSpam));
	}

	@Test
	public void testMarkFlags() {
		loginPage = new LoginPage(driver);
		incommingLetters = new IncommingLetters(driver);
		spamLetters = new SpamLetters(driver);
		loginPage.enterData("parfeevets.marina", "automationCourse");
		loginPage.clickEnterButton();
		new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Входящие"));
		incommingLetters.clickIncomming();
		// mark 3 random letters
		incommingLetters.markFlagToRandomAmountOfLetters(driver, 3);
		// delete flags(if they are) to all selected letters
		incommingLetters.markFlagToAllLetters(driver);
		Assert.assertTrue(incommingLetters.AreAllLettersSelectedFlag());
		incommingLetters.removeFlagToAllSelectedLetters();
		Assert.assertTrue(incommingLetters.isNoOneLetterSelectedFlag());
	}
}

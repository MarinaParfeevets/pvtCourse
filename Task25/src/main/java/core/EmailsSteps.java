package core;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailsSteps {
	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private UserDataTable userDataTable;
	private WebDriver webDriver;

	public EmailsSteps() {
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		loginPage.setInitialProperty();
		userDataTable = new UserDataTable();
		userDataTable.setUserLoginPasswordFromDB();
	}

	@Given("^Main application page is opened$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
	}

	@When("^Enter correct user login and password$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPass(userDataTable.getUserLogin(), userDataTable.getUserPassword());
		loginPage.clickEnterButton();
	}

	@Then("^Logout link is displayed$")
	public void seeLogoutLink() {
		Assert.assertTrue(loginPage.logoutLinkPresents());
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}
}

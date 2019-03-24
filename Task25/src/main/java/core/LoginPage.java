package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends InitialPage {

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='mailbox:submit']/input")
	private WebElement buttonEnter;

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = "//*[@id='mailbox:error']")
	public WebElement logoutLinkError;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterLoginAndPass(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
	}

	public void clickEnterButton() {
		buttonEnter.click();
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public boolean logoutLinkPresents() {
		return wait.until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
	}
}

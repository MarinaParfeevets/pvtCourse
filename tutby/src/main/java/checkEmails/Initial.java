package checkEmails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Initial {
	@FindBy(xpath = ".//a[@class='enter']")
	private WebElement loginLink;
	@FindBy(xpath = ".//input[@name='login']")
	private WebElement loginField;
	@FindBy(xpath = ".//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = ".//input[@class='button auth__enter']")
	private WebElement enterButton;
	@FindBy(xpath = "(.//a[@title='Почта'])[1]")
	private WebElement mailBoxLink;

	public Initial(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logInAccount(String login, String password) {
		clickButton(loginLink);
		inputTextToField(login, loginField);
		inputTextToField(password, passwordField);
		clickButton(enterButton);
	}

	public void goToMailBox() {
		clickButton(mailBoxLink);
	}

	private void inputTextToField(String text, WebElement fieldForInput) {
		fieldForInput.clear();
		fieldForInput.sendKeys(text);
	}

	private void clickButton(WebElement button) {
		button.click();
	}
}
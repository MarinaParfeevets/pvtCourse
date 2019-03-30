package emailsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseInitial.InitialPage;
import parserEmail.NewEmailInfo;

public class NewLetterPage extends InitialPage {
	@FindBy(xpath = "(.//*[@data-original-name='To'])[1]")
	private WebElement recieverField;
	@FindBy(xpath = ".//input[@name='Subject']")
	private WebElement subjecOftLetterField;
	@FindBy(xpath = "(.//div[@data-name='send'])[1]")
	private WebElement sendButton;
	@FindBy(xpath = ".//*[@id='b-compose__sent']/div/div[1]/div")
	private WebElement checkIsSend;
	@FindBy(xpath = "//iframe[starts-with(@id,'toolkit')]")
	private WebElement frameText;
	@FindBy(id = "tinymce")
	private WebElement inputText;
	@FindBy(xpath = ".//*[@id='b-toolbar__left']/div/div/div[2]/div/a")
	private WebElement writeEmailButton;

	public NewLetterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void writeNewEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(writeEmailButton));
		writeEmailButton.click();
	}

	public void createLetter(NewEmailInfo createNewLetterInfo) {
		inputReceiversGroupAndSubjectOfLetter(createNewLetterInfo.getRecievers(), createNewLetterInfo.getSubject());
		inputText(createNewLetterInfo.getTextOfLetter());
	}

	private void inputReceiversGroupAndSubjectOfLetter(String recievers, String subject) {
		recieverField.sendKeys(recievers);
		subjecOftLetterField.sendKeys(subject);
	}

	private void inputText(String text) {
		driver.switchTo().frame(frameText);
		inputText.click();
		inputText.clear();
		inputText.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void sendLetter() {
		sendButton.click();
		wait.until(ExpectedConditions.titleContains("Письмо отправлено"));
	}

	public boolean checkIsMessageSent() {
		return checkIsSend.isDisplayed();
	}
}

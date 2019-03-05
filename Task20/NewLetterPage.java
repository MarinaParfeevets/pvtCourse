package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLetterPage {
	@FindBy(xpath = "(.//*[@data-original-name='To'])[1]")
	private WebElement recieverField;
	@FindBy(xpath = ".//input[@name='Subject']")
	private WebElement subjecOftLetterField;
	@FindBy(xpath = "(.//div[@data-name='send'])[1]")
	private WebElement sendButton;
	@FindBy(xpath = ".//*[@id=\"b-compose__sent\"]/div/div[1]/div")
	private WebElement checkIsSend;
	@FindBy(xpath = "//iframe[starts-with(@id,'toolkit')]")
	private WebElement frameText;
	@FindBy(id = "tinymce")
	private WebElement inputText;

	public NewLetterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createLetter(CreateNewLetterInfo createNewLetterInfo, WebDriver driver) {
		inputReceiversGroupAndSubjectOfLetter(createNewLetterInfo.getRecievers(), createNewLetterInfo.getSubject());
		inputText(createNewLetterInfo.getTextOfLetter(), driver);
	}

	private void inputReceiversGroupAndSubjectOfLetter(String recievers, String subject) {
		recieverField.sendKeys(recievers);
		subjecOftLetterField.sendKeys(subject);
	}

	private void inputText(String text, WebDriver driver) {
		driver.switchTo().frame(frameText);
		inputText.click();
		inputText.sendKeys(text);
		driver.switchTo().defaultContent();
	}

	public void sendLetter() {
		sendButton.click();
	}

	public boolean checkIsMessageSent() {
		return checkIsSend.isDisplayed();
	}
}

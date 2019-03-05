package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamLetters {
	@FindBy(xpath = "(.//span[@class=\"b-nav__item__text\"])[5]")
	private WebElement spamlink;
	@FindBy(xpath = "(.//a[@href=\"/messages/inbox/\"])[2]")
	private WebElement incommingLink;
	@FindBy(xpath = ".//div[@data-bem=\"b-datalist__item\"]")
	private List<WebElement> lettersInSpam;
	@FindBy(xpath = ".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]")
	private List<WebElement> lettersInSpamCheckBoxes;
	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	private WebElement notspamButton;

	public SpamLetters(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSpam() {
		spamlink.click();
	}

	public void clickIncomming(WebDriver driver) {
		driver.navigate().to("https://e.mail.ru/messages/inbox/");
	}

	public List<WebElement> getListOfLetters() {
		return lettersInSpam;
	}

	public boolean isListOfLetterEmpty() {
		return lettersInSpam.isEmpty();
	}

	public String getLetterTextByIndex(int index) {
		if (index > lettersInSpam.size() + 1) {
			throw new IndexOutOfBoundsException();
		}
		return lettersInSpam.get(index).getText();
	}

	private void selectLetterByIndex(int index) {
		if (!isListOfLetterEmpty()) {
			WebElement check = lettersInSpamCheckBoxes.get(index);
			if (!check.isSelected()) {
				check.click();
			}
		}
	}

	public String textLetterToResroteFromSpamByIndex(int index) {
		selectLetterByIndex(index);
		String textLetter = getLetterTextByIndex(index);
		notspamButton.click();
		return textLetter;
	}

	public boolean isLetterWithTextInList(String str) {
		for (WebElement el : lettersInSpam) {
			if (el.getText() == str) {
				return false;
			}
		}
		return true;
	}
}

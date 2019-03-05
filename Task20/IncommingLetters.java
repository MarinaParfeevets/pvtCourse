package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncommingLetters {
	private Robot robot;
	@FindBy(xpath = ".//span[text()=\"Входящие\"]")
	private WebElement incommingLink;
	@FindBy(xpath = "(.//a[@href=\"/messages/spam/\"])[1]")
	private WebElement spamLink;
	@FindBy(xpath = ".//div[@class=\"b-datalist__item__subj\"]")
	private List<WebElement> letters;
	@FindBy(xpath = ".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]")
	private List<WebElement> lettersCheckBoxes;
	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	private WebElement spamButton;
	@FindBy(xpath = "(.//div[@class=\"b-dropdown__ctrl js-shortcut\"])[6]")
	private WebElement moreDropdown;
	@FindBy(xpath = ".//div[@data-bem=\"b-flag\"]")
	private List<WebElement> flag;
	@FindBy(xpath = ".//*[@id='b-toolbar__left']/div/div/div[2]/div/a")
	private WebElement writeLetterButton;
	private WebElement markCheckBox;
	private WebElement markFlag;

	public IncommingLetters(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getLetters() {
		return letters;
	}

	public void clickIncomming() {
		incommingLink.click();
	}

	public void clickSpam(WebDriver driver) {
		driver.navigate().to("https://e.mail.ru/messages/spam/");
	}

	public List<WebElement> getListOfLetters() {
		return letters;
	}

	public boolean isListOfLetterEmpty() {
		return letters.isEmpty();
	}

	public String getLetterTextByIndex(int index) {
		if (index > letters.size() + 1) {
			throw new IndexOutOfBoundsException();
		}
		return letters.get(index).getText();
	}

	private void selectLetterByIndex(int index) {
		if (!isListOfLetterEmpty()) {
			WebElement check = lettersCheckBoxes.get(index);
			selectLetter(check);
		}
	}

	public String textLetterWhichRelocatedToSpamByIndex(int index) {
		selectLetterByIndex(index);
		String textLetter = getLetterTextByIndex(index);
		spamButton.click();
		return textLetter;
	}

	public boolean isLetterWithTextInList(String str) {
		for (WebElement el : letters) {
			if (el.getText() == str) {
				return false;
			}
		}
		return true;
	}

	public void selectRandomAmountOfLetters(int amount) {
		int[] number = new int[amount];
		for (int i = 0; i < amount; i++) {
			number[i] = (int) (Math.random() * (letters.size() - 2));
		}
		for (int i = 0; i < amount; i++) {
			selectLetterByIndex(number[i]);
		}
	}

	private void pressFlagKey() {
		try {
			robot = new Robot();
			robot.keyPress(73);
			robot.keyRelease(73);
		} catch (AWTException ex) {
			System.out.println("Can't press button 'I' to mark flags");
		}
	}

	public void markFlagToRandomAmountOfLetters(WebDriver driver, int amount) {
		selectRandomAmountOfLetters(amount);
		pressFlagKey();
	}

	private void selectLetter(WebElement check) {
		if (!check.isSelected()) {
			check.click();
		}
	}

	public void markFlagToAllLetters(WebDriver driver) {
		for (int i = 0; i < lettersCheckBoxes.size(); i++) {
			markCheckBox = lettersCheckBoxes.get(i);
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(markCheckBox));
			selectLetter(markCheckBox);
		}
		pressFlagKey();
	}

	public void removeFlagToAllSelectedLetters() {
		int count = 0;
		for (int i = 0; i < flag.size(); i++) {
			markFlag = flag.get(i);
			if (markFlag.getAttribute("title").equals("Снять флажок")) {
				count++;
			}
		}
		if (count > 0) {
			pressFlagKey();
		}
	}

	public boolean isNoOneLetterSelectedFlag() {
		for (int i = 0; i < flag.size(); i++) {
			markFlag = flag.get(i);
			if (markFlag.getAttribute("title").equals("Снять флажок")) {
				return false;
			}
		}
		return true;
	}

	public boolean AreAllLettersSelectedFlag() {
		for (int i = 0; i < flag.size(); i++) {
			markFlag = flag.get(i);
			if (markFlag.getAttribute("title").equals("Пометить флажком")) {
				return false;
			}
		}
		return true;
	}

	public void writeNewLetter() {
		writeLetterButton.click();
	}
}

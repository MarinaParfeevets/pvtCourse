package checkEmails;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Emails {
	@FindBy(xpath = ".//div[@class='ns-view-container-desc mail-MessagesList js-messages-list']/div")
	private List<WebElement> inBoxEmails;
	private static final int TIMEOUT = 20;
	private WebDriver driver;

	public Emails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean isListOfEmailsEmpty() {
		(new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(inBoxEmails));
		return inBoxEmails.isEmpty();
	}

	public int countOfEmailsInInBox() {
		return inBoxEmails.size();
	}
}

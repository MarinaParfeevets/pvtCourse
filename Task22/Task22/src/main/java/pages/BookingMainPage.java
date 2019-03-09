package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingMainPage {
	private WebDriver driver;
	@FindBy(id = "ss")
	private WebElement cityToTravelField;
	@FindBy(className = "xp__dates-inner")
	private WebElement dateSelectBox;
	@FindBy(xpath = ".//td[@data-date=\"2019-03-20\"]")
	private WebElement dateFrom;
	@FindBy(xpath = ".//td[@data-date=\"2019-03-25\"]")
	private WebElement dateTo;
	@FindBy(className = "sb-searchbox__button  ")
	private WebElement searchButton;

	public BookingMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void inputCityToTravel(String city) {
		cityToTravelField.clear();
		cityToTravelField.sendKeys(city);
	}

	public void inputDateForTravel() {
		dateSelectBox.click();
		dateFrom.click();
		dateTo.click();
	}

	public void searchHotels() {
		searchButton.click();
	}

	public boolean isPageOpened(String title) {
		return driver.getTitle().contains(title);
	}
}

package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingFilterPage {
	private WebDriver driver;
	private String winHandleBefore;
	@FindBy(xpath = ".//a[@class=\"hotel_name_link url\"]")
	private List<WebElement> hotelsList;
	@FindBy(xpath = ".//*[@class=\" sort_category   sort_review_score_and_price \"]")
	private WebElement filterScoreAndPriceButton;
	@FindBy(xpath = "(.//div[@class=\"bui-review-score__badge\"])[1]")
	private WebElement ratingOfHotel;

	public BookingFilterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hotelsListIsEmpty() {
		return hotelsList.isEmpty();
	}

	public void filterScoreAndPrice() {
		filterScoreAndPriceButton.click();
	}

	public void openFirstHotel() {
		winHandleBefore = driver.getWindowHandle();
		final Set<String> oldWindowsSet = driver.getWindowHandles();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(hotelsList.get(0)));
		hotelsList.get(0).click();
		String winHandleNew = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<String>() {
			public String apply(WebDriver driver) {
				Set<String> newWindowsSet = driver.getWindowHandles();
				newWindowsSet.removeAll(oldWindowsSet);
				return newWindowsSet.size() > 0 ? newWindowsSet.iterator().next() : null;
			}
		});
		driver.switchTo().window(winHandleNew);
	}

	public void closeCurrentwindow() {
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	public double getRatingOfHotel() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(.//div[@class=\"bui-review-score__badge\"])[1]")));
		return Double.parseDouble(ratingOfHotel.getText());
	}

	public boolean isRatingMoreThanValue(double hotelRating, double value) {
		return hotelRating >= value;
	}

}

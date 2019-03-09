package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps {
	private static final String MAIN_URL = "http://www.booking.com/";
	private WebDriver driver;
	private BookingFilterPage bookingFilterPage;
	private BookingMainPage bookingMainPage;

	public BookingSteps() {
		driver = new ChromeDriver();
		bookingMainPage = new BookingMainPage(driver);
		bookingFilterPage = new BookingFilterPage(driver);
	}

	@Given("^Open main application page$")
	public void loadMainPage() {
		driver.get(MAIN_URL);
		driver.manage().window().maximize();
	}

	@When("^Input  \"([^\"]*)\" in city field$")
	public void inputCity(String city) {
		bookingMainPage.inputCityToTravel(city);
	}

	@When("^Input date of travel in date form$")
	public void inputDate() {
		bookingMainPage.inputDateForTravel();
	}

	@When("^Click search button$")
	public void clickSearchButton() {
		bookingMainPage.searchHotels();
	}

	@And("^Apply filter by score and review$")
	public void filterByScoreAndPice() {
		bookingFilterPage.filterScoreAndPrice();
	}

	@And("^Open list of hotels$")
	public void clickFirstHotelInList() {
		bookingFilterPage.openFirstHotel();
	}

	@Then("^Compare is rating more than value '9'$")
	public void compareRatingWithValue() {
		double valueRaring = 9;
		boolean compareRating = bookingFilterPage.isRatingMoreThanValue(bookingFilterPage.getRatingOfHotel(),
				valueRaring);
		Assert.assertTrue("Rating of the first hotel is less than needed!", compareRating);
	}

	@Then("^Is any hotel in filter list$")
	public void isAnyHotelInList() {
		Assert.assertFalse("There is no any hotel!", bookingFilterPage.hotelsListIsEmpty());
	}

	@Then("^Title \"([^\"]*)\" on the top right corner$")
	public void isMainPageOpened(String title) {
		Assert.assertTrue(bookingMainPage.isPageOpened(title));
	}

	@After
	public void afterClass() {
		driver.quit();
	}
}

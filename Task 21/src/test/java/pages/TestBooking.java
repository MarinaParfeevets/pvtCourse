package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBooking {
	private WebDriver driver;
	private BookingFilterPage bookingFilterPage;
	private BookingMainPage bookingMainPage;
	private String city;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://www.booking.com/");
		driver.manage().window().maximize();
		bookingMainPage = new BookingMainPage(driver);
		bookingFilterPage = new BookingFilterPage(driver);
		city = "Москва";
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkAreHotelsInMoscowByDate() {
		bookingMainPage.inputCityToTravel(city);
		bookingMainPage.inputDateForTravel();
		bookingMainPage.searchHotels();
		Assert.assertFalse("There is no any hotel!", bookingFilterPage.hotelsListIsEmpty());
	}

	@Test
	public void checkRatingOfHotelInMoscow() {
		bookingMainPage.inputCityToTravel(city);
		bookingMainPage.inputDateForTravel();
		bookingMainPage.searchHotels();
		bookingFilterPage.filterScoreAndPrice();
		bookingFilterPage.openFirstHotel();
		double valueRaring = 9;
		boolean compareRating = bookingFilterPage.isRatingMoreThanValue(bookingFilterPage.getRatingOfHotel(),
				valueRaring);
		Assert.assertTrue("Rating of the first hotel is less than needed!", compareRating);
	}

}

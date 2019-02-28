package core;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBookingCom {
	WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Execution of TestBookingCom class is started!");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Execution of TestBookingCom class is finished!");
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	private void findHotels() {
		driver.get("http://www.booking.com/");
		WebElement element = driver.findElement(By.id("ss"));
		element.clear();
		element.sendKeys("Москва");
		driver.findElement(By.className("xp__dates-inner")).click();
		driver.findElement(By.xpath(".//td[@data-date=\"2019-03-01\"]")).click();
		driver.findElement(By.xpath(".//td[@data-date=\"2019-03-04\"]")).click();
		driver.findElement(By.className("sb-searchbox__button  ")).click();
	}

	@Test
	public void checkAreHotelsInMoscowByDate() {
		findHotels();
		List<WebElement> hotels = driver.findElements(By.xpath(".//div[@data-et-view=\" eWHJbWPNZWEHXT:5\"]"));
		Assert.assertFalse("There is no any hotel!", hotels.isEmpty());
	}

	@Test
	public void checkRatingOfHotelInMoscow() {
		findHotels();
		driver.findElement(By.xpath(".//*[@class=\" sort_category   sort_review_score_and_price \"]")).click();
		driver.findElement(By.xpath("(.//a[@class=\"hotel_name_link url\"])[1]")).click();
		List<WebElement> ratingList = driver.findElements(By.xpath(".//*[@class=\"bui-review-score__badge\"]"));
		double rating = Double.parseDouble(ratingList.get(0).getText());
		boolean compareRating = (rating >= 9);
		Assert.assertTrue("Rating of the first hotel is less than '9'!", compareRating);
	}
}

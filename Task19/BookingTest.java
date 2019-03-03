package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingTest {
	WebDriver driver;
	WebElement element;
	private int amountDays = 7;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Execution of TestBookingCom class is started");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Execution of TestBookingCom class is finished");
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://www.booking.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	private void filterHotels(int amountAdult, int amountRoom) {
		element = driver.findElement(By.id("ss"));
		element.clear();
		element.sendKeys("Париж");
		driver.findElement(By.className("xp__dates-inner")).click();
		driver.findElement(By.xpath(".//td[@data-date=\"2019-03-03\"]")).click();
		driver.findElement(By.xpath(".//td[@data-date=\"2019-03-09\"]")).click();
		driver.findElement(By.className("sb-searchbox__button  ")).click();
		element = driver.findElement(By.id("group_adults"));
		Select adultGroup = new Select(element);
		adultGroup.selectByIndex(amountAdult - 1);
		element = driver.findElement(By.id("no_rooms"));
		Select roomGroup = new Select(element);
		roomGroup.selectByIndex(amountRoom - 1);
		element = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		element.click();
	}

	private boolean priceIsInRange(String price, String range) {
		int positionMaxRange = 4;
		int positionMinRange = 1;
		String[] str = price.split(" ");
		int positionPrice = str.length - 1;
		int priceByNight = Integer.parseInt(str[positionPrice].trim()) / (amountDays - 1);
		str = range.split(" ");
		int minRange = Integer.parseInt(str[positionMinRange].trim());
		if (str.length == positionMaxRange + 1) {
			return (priceByNight >= minRange);
		} else {
			int maxRange = Integer.parseInt(str[positionMaxRange].trim());
			return (priceByNight >= minRange && priceByNight <= maxRange);
		}
	}

	@Test
	public void testFindTheCheapestHotel() {
		int amountAdults = 2;
		int amountRooms = 1;
		filterHotels(amountAdults, amountRooms);
		driver.findElement(By.xpath(".//*[@id=\"filter_price\"]/div[2]/a[1]")).click();
		List<WebElement> hotels = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		Assert.assertFalse("There is no any hotel!", hotels.isEmpty());
		driver.findElement(By.xpath(".//button[@id=\"sortbar_dropdown_button\"]")).click();
		driver.findElement(By.xpath(".//li[@class=\" sort_category   sort_bayesian_review_score \"]")).click();
		String price = driver.findElement(By.xpath("(.//*[@class=\"roomPrice  sr_discount \"])[1]/div/strong/b"))
				.getText();
		String range = driver
				.findElement(By.xpath("(.//a[@class=\" filterelement bui-checkbox    active     \"])/div/span"))
				.getText();
		Assert.assertTrue(priceIsInRange(price, range));
	}

	@Test
	public void testFindTheCheapestFromRich() {
		int amountAdults = 4;
		int amountRooms = 2;
		filterHotels(amountAdults, amountRooms);
		List<WebElement> yourBudgetCheckBox = driver.findElements(By.xpath(".//*[@id=\"filter_price\"]/div[2]/a"));
		WebElement richestHotels = yourBudgetCheckBox.get(4);
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("arguments[0].scrollIntoView(true);", richestHotels);
		richestHotels.click();
		List<WebElement> hotels = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		Assert.assertFalse("There is no any hotel!", hotels.isEmpty());
		driver.findElement(By.xpath(".//li[@class=\" sort_category  selected  sort_price \"]")).click();
		String price = driver.findElement(By.xpath("(.//*[@class=\"roomPrice  sr_discount \"])[1]/div/strong/b"))
				.getText();
		String range = driver.findElement(By.xpath("//*[@id=\"filter_price\"]/div[2]/a[5]/div/span[1]")).getText();
		Assert.assertTrue(priceIsInRange(price, range));
	}
}

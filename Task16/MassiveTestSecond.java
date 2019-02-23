package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MassiveTestSecond {
	Massive massive = new Massive();

	@Test(dataProvider = "dp1")
	public void testEquals(int[] masFirst, int[] masSecond) {
		massive.setMas(masFirst);
		Assert.assertTrue(massive.equals(masSecond), "Arrays are not equals!");
	}

	@DataProvider
	public Object[][] dp1() {
		return new Object[][] { 
			{ new int[] { 1, 2, 4, 3, 5, 6 }, new int[] { 1, 2, 4, 3, 5, 6 } },
			{ new int[] { 2, 3, 8 }, new int[] { 3, 2 } }, 
			{ new int[] { 2, 3 }, new int[] { 3, 2 } } };
	}

	@Test(dataProvider = "dpSum")
	public void testGetSum(int[] mas, int sum) {
		massive.setMas(mas);
		Assert.assertEquals(massive.getSumOfElements(), sum, "Sums of elements are not equals!");
	}

	@DataProvider
	public Object[][] dpSum() {
		return new Object[][] { 
			{ new int[] { 1, 2, 4, 3, 5, 6 }, 21 }, 
			{ new int[] { -2, -1, 2 }, -1 },
			{ new int[] { 0 }, 0 } };
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("---Before Method 2---");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("---After Method 2---");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("---Before Class 2---");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("---After Class 2---");
	}
}

package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MassiveTestIncreaseDecrease {
	Massive massive = new Massive();

	@Test(dataProvider = "dpIncrease")
	public void testIncreaseTo(int[] masActual, int[] masExpected, int number) {
		massive.setMas(masActual);
		Assert.assertTrue(Arrays.equals(massive.increaseTo(number), masExpected));
	}

	@DataProvider
	public Object[][] dpIncrease() {
		return new Object[][] { 
			{ new int[] { 1, 2, 4, 3, 0 }, new int[] { 3, 4, 6, 5, 2 }, 2 },
			{ new int[] { -2, -3 }, new int[] { -4, -5 }, -2 }, 
			{ new int[] { 2, 3 }, new int[] { 1, 2 }, -1 } };
	}

	@Test(dataProvider = "dpDecrease")
	public void testDecreaseTo(int[] masActual, int[] masExpected, int number) {
		massive.setMas(masActual);
		Assert.assertTrue(Arrays.equals(massive.decreaseTo(number), masExpected));
	}

	@DataProvider
	public Object[][] dpDecrease() {
		return new Object[][] { 
			{ new int[] { 1, 2, 0 }, new int[] { -1, -2, 0 }, -1 },
			{ new int[] { 20, 30 }, new int[] { 10, 15 }, 2 } };
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void testDecreaseToExc() {
		massive.setMas(new int[] { 2, 6, 8 });
		massive.decreaseTo(0);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("---Before Method 3---");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("---After Method 3---");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("---Before Class MassiveTestIncreaseDecrease---");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("---After Class MassiveTestIncreaseDecrease---");
	}
}

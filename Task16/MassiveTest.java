package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MassiveTest {
	private Massive massive;
	private Massive massive2;

	@Test
	public void testGetMas() {
		int[] expected = { 1, 5, 2, 3 };
		Assert.assertTrue(Arrays.equals(massive.getMas(), expected));
	}

	@Test(enabled = false)
	public void testGetMasIgn() {
		System.out.println("Test realization in progress");
	}

	@Test
	public void testFailed() {
		Assert.fail("Test realization in progress");
	}

	@Test
	public void testGetStr() {
		String expected = "Actual String";
		Assert.assertEquals(massive.getStr(), expected);
	}

	@Test
	public void testSize() {
		int expected = massive.getMas().length;
		Assert.assertEquals(massive.getSize(), expected); 
	}

	@Test
	public void testEqualsMaxToNumber() {
		Assert.assertTrue(massive.isEqualMaxToNumber(5), "Max element is not equals to number!");
	}

	@Test
	public void testEqualsMaxToNumberFalse() {
		Assert.assertFalse(massive.isEqualMaxToNumber(10), "Max element is equals to number!");
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testGetFifthElementExc() {
		massive.getFifthElement();
	}

	@Test
	public void testGetFifthElement() {
		massive2 = new Massive();
		massive2.setMas(new int[] { 1, 2, 3, 7, 4, 9, 0 });
		Assert.assertEquals(massive2.getFifthElement(), 4);
	}

	@Test
	public void testGetStrNotNull() {
		Assert.assertNotNull(massive.getStr());
	}

	@Test
	public void testGetString() {
		String expected = "Hello";
		massive.setStr(expected);
		Assert.assertEquals(massive.getStr(), expected);
	}

	@Test
	public void testReverse() {
		int[] expected = { 3, 2, 5, 1 };
		Assert.assertTrue(Arrays.equals(massive.reverse(), expected), "Arrays are not equals");
	}

	@Test(timeOut = 100)
	public void testNewString() {
		String str = " New";
		String expected = massive.getStr() + str;
		Assert.assertEquals(massive.newString(str), expected);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("---Before Method 1---");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("---After Method 1---");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("---Before Class MassiveTest---");
		massive = new Massive(new int[] { 1, 5, 2, 3 }, "Actual String");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("---After Class MassiveTest---");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("---Before Test Massive---");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("---After Test Massive---");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("---Before SuiteMassive---");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("---After SuiteMassive---");
	}
}

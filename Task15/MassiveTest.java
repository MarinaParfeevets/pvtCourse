package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MassiveTest {
	private Massive massive;

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("---BeforeClass");
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("---AfterClass");
	}

	@Before
	public void setMassive() throws Exception {
		System.out.println("---Before Method");
		massive = new Massive(new int[] { 1, 2, 3, 4, 6, 7 }, 10, "Hello");
	}

	@After
	public void afterMethod() throws Exception {
		System.out.println("---After Method");
	}

	@Test
	public void testEquals() {
		int[] masEqual = { 1, 2, 3, 4, 6, 7 };
		assertTrue(massive.equals(masEqual));
	}

	@Test(timeout = 100)
	public void testReverse() {
		int[] masExpected = { 7, 6, 4, 3, 2, 1 };
		assertArrayEquals("Arrays are not equals!", masExpected, massive.reverse());
	}

	@Ignore
	@Test
	public void testEqualsIgnore() {
		int[] masEqual = { 1, 2, 3, 4, 6, 7 };
		assertTrue(massive.equals(masEqual));
	}

	@Test
	public void testReverseIgnore() {
		fail("This test is in ignore");
		int[] masExpected = { 7, 6, 4, 9, 1 };
		assertArrayEquals("Arrays are not equals!", masExpected, massive.reverse());
	}

	@Test(expected = ArithmeticException.class)
	public void testDecreaseToExc() {
		int[] masExpected = { 1, 2, 3, 4, 6, 7 };
		assertArrayEquals(masExpected, massive.decreaseTo(0));
	}

	@Test
	public void testEqualsString() {
		String str = "Hello";
		assertSame(massive.getStr(), str);
	}

	@Test
	public void testEqualsString2() {
		String str = "Peace";
		assertNotSame(massive.getStr(), str);
	}

	@Test
	public void testMaxElement() {
		assertEquals(7, massive.maxElement());
	}
}

package core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class MassiveTest2 {
	private Massive massive;
	private int expected;
	private int[] mas;

	@Parameters
	public static Collection<Object[]> setOfParametersGetSum() {
		return Arrays.asList(new Object[][] { { 10, new int[] { 1, 2, 3, 4 } }, { -5, new int[] { -2, -4, 1 } },
				{ 0, new int[] { 0, 0 } }, });
	}

	public MassiveTest2(int expected, int[] mas) {
		this.expected = expected;
		this.mas = mas;
	}

	@Test
	public void testGetSumOfElements() {
		assertEquals(expected, massive.getSumOfElements());
	}

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
		massive = new Massive(mas, 10, "Hello");
	}

	@After
	public void afterMethod() throws Exception {
		System.out.println("---After Method");
	}

}

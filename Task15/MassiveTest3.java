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
public class MassiveTest3 {
	private Massive massive;
	private int number;
	private int[] mas;

	@Parameters
	public static Collection<Object[]> setOfParameters() {
		return Arrays.asList(new Object[][] { { 4, new int[] { 1, 2, 3, 4 } }, { -2, new int[] { -2, -4, -1 } },
				{ 15, new int[] { 6, 15, -1 } } });
	}

	public MassiveTest3(int number, int[] mas) {
		this.number = number;
		this.mas = mas;
	}

	@Test
	public void testequalMaxToNumber() {
		assertTrue("Max element not equal to number!", massive.equalMaxToNumber());
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
		massive = new Massive(mas, number);
	}

	@After
	public void afterMethod() throws Exception {
		System.out.println("---After Method");
	}

}

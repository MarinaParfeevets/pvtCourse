package core;

import java.util.Scanner;

public class Massive {
	private int[][] mas;
	private int n;
	private int m;
	private final static String error = "Error! ";
	private final static String errInfo = " Method returns '0'!";
	private static Scanner scan;

	// try-catch
	public Massive(int n, int m) {
		try {
			this.n = n;
			this.m = m;
			mas = new int[n][m];
		} catch (NegativeArraySizeException e) {
			System.out.println(error + "Array size is negative!");
		}
	}

	// try with several catch
	public void createStrangeRandomMassive() {
		int range = 10;
		try {
			for (int i = 0; i < n; i++)
				for (int j = 0; j <= m; j++) {
					this.mas[i][j] = (int) (Math.random() * range) / (n - m + i + j);
				}
		} catch (ArithmeticException e) {
			System.out.println(error + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(error + e);
		}
	}

	// try-catch-finally
	public static double inputDouble() {
		double res = 0;
		scan = new Scanner(System.in);
		try {
			res = Double.parseDouble(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(error + "Impossible to parse string to double!" + errInfo);
		} finally {
			scan.close();
		}
		return res;
	}

	// multi catch
	public void changedMassive() {
		try {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					this.mas[i][j] = mas[i + 1][j + 1] / mas[i][j];
					System.out.println(mas[i][j]);
				}
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.err.println(error + e.toString());
		}
	}

	// try with resources
	public int inputSizeN() {
		System.out.println("Input size n: ");
		try (Scanner scanner = new Scanner(System.in)) {
			n = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(error + "Illegal not integer input! " + e.getMessage());
		}
		return n;
	}

	// try inside try
	public void elementXYIndexDivisionByValueAnotherSumValue(int xIndex, int yIndex, int value) {
		try {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					if (i == xIndex && j == yIndex) {
						try {
							mas[i][j] = mas[xIndex][yIndex] / value;
						} catch (ArithmeticException e) {
							System.out.println(error + e.getClass().getSimpleName() + " Division by zero!");
						}
					} else {
						mas[i][j] = mas[xIndex][yIndex] + value;
					}
				}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(error + e);
		}
	}

	// method with finally never called
	public void methodWithoutLogic() {
		try {
			System.out.println("Method without logic is running");
			System.exit(0);
		} catch (SecurityException e) {
			System.out.println(e.getClass().getSimpleName());
		} finally {
			System.out.println("You'll never see this message. ");
		}
	}

}

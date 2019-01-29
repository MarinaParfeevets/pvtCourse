package core;

public class Task3_1 {

	public static void main(String[] args) {

		int n = 10;

		for (int i = 1; i <= n; i++) {
			double number1 = Math.random() * n;
			double number2 = Math.random() * n;

			System.out.println(
					i + " Минимальное число среди " + number1 + "и " + number2 + " = " + minNumber(number1, number2));
		}
	}

	public static double minNumber(double a, double b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
}

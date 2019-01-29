package core;

import java.util.Scanner;

public class Task3_2 {

	public static void main(String[] args) {

		int number;
		int countOfNumbers = 5;// how many number we are going to check
		Scanner scan = new Scanner(System.in);
		boolean parity;
		for (int i = 1; i <= countOfNumbers; i++) {
			System.out.print("Введите число: ");
			number = scan.nextInt();
			parity = checkParity(number);

			if (parity) {
				System.out.println("Число " + number + " четное!");
			} else {
				System.out.println("Число " + number + " не четное!");
			}
		}
		scan.close();
	}

	public static boolean checkParity(int a) {
		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}

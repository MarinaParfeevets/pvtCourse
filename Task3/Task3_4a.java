package core;

import java.util.Scanner;

public class Task3_4 {
	public static void main(String[] args) {

		int n = 10;
		int num;
		int pow;
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("В какую степень хотите возмести число? Введите: ");
			pow = scan.nextInt();
			if (pow < 0) {
				System.out.println("Только положительное целое число! Попробуйте еще раз. ");
				continue;
			}
			num = (int) (Math.random() * n);
			System.out.println("Число " + num + " в " + pow + " степени = " + powIntNumber(num, pow));
		}
		scan.close();
	}

	public static int powIntNumber(int a, int pow) {

		int res = 1;
		//for pow == 0 will return res = 1
		if (pow > 0) {
			for (int i = 1; i <= pow; i++) {
				res = res * a;
			}  
		}
		return res;
	}

}

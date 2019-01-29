package core_extra;

import java.util.Scanner;

public class Task3_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		mas = printRandomMas(mas);
		if (checkZero(mas) == 0) {
			System.out.println("\nНулевые элементы отсутствуют ");
		} else {
			System.out.println("\nКоличество нулевых элементов = " + checkZero(mas));
		}
	}

	public static int[] printRandomMas(int[] mas) {
		int n = 10;
		System.out.println("Массив: ");
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}
		return mas;
	}

	public static int checkZero(int[] mas) {
		int res = 0;
		for (int i = 0; i < mas.length; i++) {
			if (mas[i] == 0) {
				res++;
			}
		}
		return res;
	}
}

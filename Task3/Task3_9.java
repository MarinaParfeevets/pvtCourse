package core_extra;

import java.util.Scanner;

public class Task3_9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		System.out.println("Массив: ");
		mas = randomMas(mas);
		printMas(mas);
		System.out.println("\nПорядковый номер минимального элемента: " + (minIndex(mas) + 1));
		System.out.println("Порядковый номер максимального элемента:" + (maxIndex(mas) + 1));
	}

	public static int[] randomMas(int[] mas) {
		int n = 100;
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n - n / 2);
		}
		return mas;
	}

	public static void printMas(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static int minIndex(int[] mas) {
		int res = 0;
		int min = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < min) {
				min = mas[i];
				res = i;
			}
		}
		return res;
	}

	public static int maxIndex(int[] mas) {
		int res = 0;
		int max = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] > max) {
				max = mas[i];
				res = i;
			}
		}
		return res;
	}
}

package core_extra;

import java.util.Scanner;

public class Task3_11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		double[] mas = new double[size];

		System.out.println("Массив: ");
		mas = randomMas(mas);
		printMas(mas);
			
		System.out.print("\nМассив после замены элементов на полусумму соседних элементов:\n");
		mas = halfSumMas(mas);
		printMas(mas);
	}
	public static double[] randomMas(double[] mas) {
		int n = 10;
		for (int i = 0; i < mas.length; i++) {
			mas[i] =Math.random() * n;
		}
		return mas;
	}

	public static void printMas(double[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.printf(" %.2f", mas[i]);
		}
	}
	public static double[] halfSumMas(double[] mas) {
		int size = mas.length;
		double mas1[]= new double[size];
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				mas1[i] = mas[i + 1] / 2;
			} else if (i == size - 1) {
				mas1[i] = mas[i - 1] / 2;
			} else {
				mas1[i] = (mas[i - 1] + mas[i + 1]) / 2;
			}
		}
		return mas1;
	}
}

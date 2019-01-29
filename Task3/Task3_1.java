package core_extra;

import java.util.Scanner;

public class Task3_1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		createPrintMassive(mas);
		printReverseMassive(mas);
	}

	public static void createPrintMassive(int[] mas) {

		int n = 100;
		System.out.println("Массив в прямом порядке: ");
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}
	}

	public static void printReverseMassive(int[] mas) {

		int i = mas.length - 1;
		System.out.println("\nМассив в обратном порядке: ");
		while (i >= 0) {
			System.out.print(mas[i] + " ");
			i--;
		}
	}

}

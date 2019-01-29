package core_extra;

import java.util.Scanner;

public class Task3_13_extra {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите количество строк в массиве: ");
		int size1 = scan.nextInt();
		System.out.print("Введите количество столбцов в массиве: ");
		int size2 = scan.nextInt();
		int[][] mas = new int[size1][size2];
		scan.close();

		System.out.print("\nМассив в прямом порядке: ");
		mas = randomMas(mas);
		printMas(mas);
		System.out.print("\n\nМассив в обратном порядке: ");
		printReverseMas(mas);
		System.out.print("\n\nМинимальный элемент: " + minElement(mas));
		System.out.print("\nМаксимальный элемент: " + maxElement(mas));
	}

	public static int[][] randomMas(int[][] mas) {
		int n = 100;
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = (int) (Math.random() * n - n / 2);
			}
		}
		return mas;
	}

	public static void printMas(int[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.println();
			for (int j = 0; j < mas[i].length; j++) {
				System.out.print(mas[i][j] + " ");
			}
		}
	}

	public static int minElement(int[][] mas) {
		int res = mas[0][0];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if (mas[i][j] < res) {
					res = mas[i][j];
				}
			}
		}
		return res;
	}

	public static int maxElement(int[][] mas) {
		int res = mas[0][0];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				if (mas[i][j] > res) {
					res = mas[i][j];
				}
			}
		}
		return res;
	}

	public static void printReverseMas(int[][] mas) {
		for (int i = mas.length - 1; i >= 0; i--) {
			System.out.println();
			for (int j = mas[i].length - 1; j >= 0; j--) {
				System.out.print(mas[i][j] + " ");
			}
		}
	}
}

package core;

import java.util.Scanner;

public class Task2_13_extra {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите количество строк в массиве: ");
		int size1 = scan.nextInt();
		System.out.print("Введите количество столбцов в массиве: ");
		int size2 = scan.nextInt();
		int[][] mas = new int[size1][size2];
		int n =100;
		int min = mas[0][0];
		int max = mas[0][0];
        scan.close();
		
		System.out.print("\nМассив в прямом порядке: ");
		for (int i = 0; i < size1; i++) {
			System.out.println();
			for (int j = 0; j < size2; j++) {
				mas[i][j] = (int) (Math.random() * n -n/2);
				if (mas[i][j] < min) {
					min = mas[i][j];
				}
				if (mas[i][j] > max) {
					max = mas[i][j];
				}
				System.out.print(mas[i][j] + " ");
			}
		}
		System.out.print("\n\nМассив в обратном порядке: ");
		for (int i = size1-1; i >= 0; i--) {
			System.out.println();
			for (int j = size2-1; j >= 0; j--) {
				System.out.print(mas[i][j] + " ");
			}
		}
		System.out.print("\n\nМинимальный элемент: " + min);
		System.out.print("\nМаксимальный элемент: " + max);
	}

}

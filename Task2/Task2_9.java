package core;

import java.util.Scanner;

public class Task2_9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n = 100;
		int min =mas[0];
		int max =mas[0];
		int min_index = 0;
		int max_index = 0;

		System.out.println("Массив: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n-n/2);
			System.out.print(mas[i] + " ");
		}
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < min) {
				min = mas[i];
				min_index = i;
			}
			if (mas[i]>max) {
				max = mas[i];
				max_index = i;
			}
		}
		System.out.println("\nПорядковый номер минимального элемента: " + (min_index+1));
		System.out.println("Порядковый номер максимального элемента:" + (max_index+1));
	}

}

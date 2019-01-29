package core;

import java.util.Scanner;

public class Task2_12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int[] mas1 = new int[size];
		int n = 100;
		int shift_right = 2; // целое положительное число сдвига

		System.out.println("Массив: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}

		for (int i = 0; i < size - shift_right; i++) {
			mas1[i + shift_right] = mas[i];
		}
		//цикл для циклического сдвига последних оставшихся элементов в начало массива
		for (int i = 0; i < shift_right; i++) {
			mas1[i] = mas[size - shift_right + i];
		}
		
		System.out.print("\nМассив после циклического сдвига элементов вправа на " + shift_right + " позиции:\n");
		for (int i = 0; i < size; i++) {
			System.out.print(mas1[i] + " ");
		}
	}
}


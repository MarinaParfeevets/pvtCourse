package core_extra;

import java.util.Scanner;

public class Task3_6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		System.out.println("Массив: ");
		mas = printRandomMas(mas);
		System.out.print("\nМассив после замены каждых двух соседних элементов:\n");
		printNewMas(mas);
	}

	public static int[] printRandomMas(int[] mas) {
		int n = 10;
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}
		return mas;
	}

	public static void printNewMas(int[] mas) {
		int a;
		for (int i = 0; i < mas.length; i += 2) {
			if ((mas.length - i) > 1) {
				a = mas[i + 1];
				mas[i + 1] = mas[i];
				mas[i] = a;
				System.out.print(mas[i] + " " + mas[i + 1] + " ");
			}
			if ((mas.length - i) == 1) {
				System.out.print(mas[mas.length - 1]);
			}
		}
	}
}

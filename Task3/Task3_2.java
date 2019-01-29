package core_extra;

import java.util.Scanner;

public class Task3_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = scan.nextInt();

		int[] mas = new int[size];
		int i = 0;

		while (i < size) {
			System.out.print("Введите элемент массива: ");
			mas[i] = scan.nextInt();
			i++;
		}
		scan.close();
		printMassive(mas);
		System.out.println("\nПроизведение всех элементов массива: " + multiplyMassive(mas));
	}

	public static void printMassive(int[] mas) {
		System.out.print("\nМассив: ");
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static int multiplyMassive(int[] mas) {
		int pr = 1;
		for (int i = 0; i < mas.length; i++) {
			pr = pr * mas[i];
		}
		return pr;
	}

}

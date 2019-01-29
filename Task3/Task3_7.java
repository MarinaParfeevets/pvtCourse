package core_extra;

import java.util.Scanner;

public class Task3_7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		mas = RandomMas(mas);
		System.out.println("Массив: ");
		printMas(mas);
		System.out.print("\nМассив после замены 1-го и последнего, 2-го и предпоследнего и т.д.:\n");
		mas = newChangedMas(mas);
		printMas(mas);
	}

	public static int[] RandomMas(int[] mas) {
		int n = 100;
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n);
		}
		return mas;
	}

	public static void printMas(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}

	public static int[] newChangedMas(int[] mas) {
		int k;
		int a;
		if (mas.length / 2 == 0) {
			k = mas.length / 2;
		} else {
			k = (int) (mas.length / 2) - 1;
		}
		for (int i = 0; i <= k; i++) {
			a = mas[i];
			mas[i] = mas[mas.length - 1 - i];
			mas[mas.length - 1 - i] = a;
		}
		return mas;
	}
}

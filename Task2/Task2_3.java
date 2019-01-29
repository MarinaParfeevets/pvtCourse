package core;

import java.util.Scanner;

public class Task2_3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива: ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int[] mas1 = new int[size];
		int n = 10;
		int k = 0;

		System.out.println("\nМассив: ");
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
			mas1[i] = mas[i];
		}
		
		System.out.println("\nКаждый 3-ий эл-т умножить на два (1-ый способ): ");
		while (k < size) {
			if ((k+1)% 3 == 0) {
				mas1[k] = mas1[k] * 2;
				System.out.print(mas1[k] + " ");
			} else {
				System.out.print(mas1[k] + " ");
			}
			k++;
		}
		System.out.println("\nКаждый 3-ий эл-т умножить на два (2-ый способ): ");
		for (int i =0; i <size; i++) {
			switch ((i+1)%3)
			{
			case 0:
				mas[i] = mas[i] * 2;
				System.out.print(mas[i] + " ");
				break;
			default:
				System.out.print(mas[i] + " ");
				break;
			}
		}
	}

}

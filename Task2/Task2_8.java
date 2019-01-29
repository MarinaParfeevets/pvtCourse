package core;

import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n = 100;
		int min =mas[0];
		int max =mas[0];

		System.out.println("������: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n-n/2);
			System.out.print(mas[i] + " ");
		}
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < min) {
				min = mas[i];
			}
			if (mas[i]>max) {
				max = mas[i];
			}
		}
		System.out.println("\n����������� ������� �������: " + min);
		System.out.println("������������ ������� �������: " + max);
	}

}

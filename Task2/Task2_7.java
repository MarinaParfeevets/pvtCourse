package core;

import java.util.Scanner;

public class Task2_7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n = 100;
		int a;
		int k;

		System.out.println("������: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}
		if (size / 2 == 0) {
			k = size / 2;
		} else {
			k = (int) (size / 2) - 1;
		}
		for (int i = 0; i <= k; i++) {
			a = mas[i];
			mas[i] = mas[size - 1 - i];
			mas[size - 1 - i] = a;
		}
		System.out.print("\n������ ����� ������ 1-�� � ����������, 2-�� � �������������� � �.�.:\n");
		for (int i = 0; i < size; i++) {
			System.out.print(mas[i] + " ");
		}
	}
}

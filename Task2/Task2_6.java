package core;

import java.util.Scanner;

public class Task2_6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n = 100;
		int a;

		System.out.println("������: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");

		}
		System.out.print("\n������ ����� ������ ������ ���� �������� ���������:\n");
		for (int i = 0; i < size; i += 2) {
			if ((size - i) > 1) {
				a = mas[i + 1];
				mas[i + 1] = mas[i];
				mas[i] = a;
				System.out.print(mas[i] + " " + mas[i + 1] + " ");
			}
			if ((size - i) == 1) {
				System.out.print(mas[size-1]);
			}

		}
	}
}

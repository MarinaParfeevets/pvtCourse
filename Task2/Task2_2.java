package core;

import java.util.Scanner;

public class Task2_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ �������: ");
		int size = scan.nextInt();
		int[] mas = new int[size];
		int i = 0;
		int pr = 1;

		while (i < size) {
			System.out.print("������� ������� �������: ");
			mas[i] = scan.nextInt();
			i++;
		}
		scan.close();
		System.out.print("\n������: ");
		for (i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}

		for (i = 0; i < mas.length; i++) {
			pr = pr * mas[i];
		}
		System.out.println("\n������������ ���� ��������� �������: " + pr);
	}

}

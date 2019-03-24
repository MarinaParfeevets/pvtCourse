package core;

import java.util.Scanner;

public class Task2_11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		double[] mas = new double[size];
		double[] mas1 = new double[size];
		int n = 10;

		System.out.println("������: ");
		for (int i = 0; i < size; i++) {
			mas[i] = Math.random() * n;
			System.out.printf(" %.2f", mas[i]);

		}
		System.out.print("\n������ ����� ������ ��������� �� ��������� �������� ���������:\n");
		//������� �������� �������������� ��� ����������� ����� �����, �� ������ ����� ����������� 
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				mas1[i] = mas[i + 1] / 2;
				System.out.printf("%.2f", mas1[i]);
			} else if (i == size - 1) {
				mas1[i] = mas[i - 1] / 2;
				System.out.printf(" %.2f", mas1[i]);
			} else {
				mas1[i] = (mas[i - 1] + mas[i + 1]) / 2;
				System.out.printf(" %.2f", mas1[i]);
			}
		}
	}
}

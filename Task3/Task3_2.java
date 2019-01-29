package core_extra;

import java.util.Scanner;

public class Task3_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ �������: ");
		int size = scan.nextInt();

		int[] mas = new int[size];
		int i = 0;

		while (i < size) {
			System.out.print("������� ������� �������: ");
			mas[i] = scan.nextInt();
			i++;
		}
		scan.close();
		printMassive(mas);
		System.out.println("\n������������ ���� ��������� �������: " + multiplyMassive(mas));
	}

	public static void printMassive(int[] mas) {
		System.out.print("\n������: ");
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

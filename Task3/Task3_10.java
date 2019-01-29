package core_extra;

import java.util.Scanner;

public class Task3_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		System.out.println("������: ");
		mas = randomMas(mas);
		printMas(mas);

		if (checkMassive(mas)) {
			System.out.println("\n������ �������� ������������ �������������������!");
		} else {
			System.out.println("\n������  �� �������� ������������ �������������������!");
		}
	}

	public static int[] randomMas(int[] mas) {
		int n = 10;
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

	public static boolean checkMassive(int[] mas) {
		int count = 1;
		while (count < mas.length) {
			if (mas[count] > mas[count - 1]) {
				count++;
			} else {
				return false;
			}
		}
		return true;
	}
}

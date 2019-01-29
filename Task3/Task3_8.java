package core_extra;

import java.util.Scanner;

public class Task3_8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];

		System.out.println("������: ");
		mas = randomMas(mas);
		printMas(mas);
		
		System.out.println("\n����������� ������� �������: " + minElement(mas));
		System.out.println("������������ ������� �������: " + maxElement(mas));
	}

	public static int[] randomMas(int[] mas) {
		int n = 100;
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (Math.random() * n - n / 2);
		}
		return mas;
	}
	public static void printMas(int[] mas) {
		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}
	public static int minElement(int[] mas) {
		int res = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < res) {
				res = mas[i];
			}
		}
		return res;
	}
	public static int maxElement(int[] mas) {
		int res = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (mas[i] > res) {
				res = mas[i];
			}
		}
		return res;
	}
}

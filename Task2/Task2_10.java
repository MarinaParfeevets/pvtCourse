package core;

import java.util.Scanner;

public class Task2_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n = 100;
		int count = 1;
		boolean bool = false;
		
		System.out.println("������: ");
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * n);
			System.out.print(mas[i] + " ");
		}
		while (count < mas.length) {
			if (mas[count] > mas[count-1]) {
				bool = true;
			}
			else {
				bool = false;
				break;
			}
			count++;
		}
		if (bool) {
			System.out.println("\n������ �������� ������������ �������������������!");
		}
		else {
			System.out.println("\n������  �� �������� ������������ �������������������!");
		}
	}

}

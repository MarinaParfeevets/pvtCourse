package core;

import java.util.Scanner;

public class Task2_4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n =10;
		int k = 0;
		
		System.out.println("������: ");
		for (int i = 0; i <size; i++) {
			mas[i] = (int) (Math.random()*n);
			System.out.print(mas[i]+ " ");
			if (mas[i] == 0) {
				k++;
			}
		}
		if (k == 0) {
			System.out.println("\n������� �������� ����������� ");
		}
		else {
			System.out.println("\n���������� ������� ��������� = " + k);
		}
	}
}


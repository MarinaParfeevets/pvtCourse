package core;

import java.util.Scanner;

public class Task2_1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n =100;
		int i1 = size - 1;
        
		System.out.println("������ � ������ �������: ");
		for (int i = 0; i <size; i++) {
			mas[i] = (int) (Math.random()*n);
			System.out.print(mas[i]+ " ");
		}
		System.out.println("\n������ � �������� �������: ");
		while (i1 >= 0) {
			System.out.print(mas[i1] + " ");
			i1--;
		}
	}

}

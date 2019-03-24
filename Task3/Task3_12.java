package core_extra;

import java.util.Scanner;

public class Task3_12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������� (����� ������������� �����): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];		
		int shift_right = 2; // ����� ������������� ����� ������

		System.out.println("������: ");
		mas = randomMas(mas);
		printMas(mas);
		
		System.out.print("\n������ ����� ������������ ������ ��������� ������ �� " + shift_right + " �������:\n");
		mas = shiftRight(mas, shift_right);
		printMas(mas);
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
	public static int[] shiftRight(int[] mas, int sr) {
		int[] mas1 = new int[mas.length];
		for (int i = 0; i < mas.length - sr; i++) {
			mas1[i + sr] = mas[i];
		}
		//���� ��� ������������ ������ ��������� ���������� ��������� � ������ �������
		for (int i = 0; i < sr; i++) {
			mas1[i] = mas[mas.length - sr + i];
		}
		return mas1;
	}
}


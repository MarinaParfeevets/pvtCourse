package core;

import java.util.Scanner;

public class Task4_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = 0;
		System.out.print("������� ������ ������� (�����, ������������� �����): ");
		if (scan.hasNextInt()) {
			size = scan.nextInt();
		}
		scan.close();
		//�������� ����� ��� ��������� �������
		int a = 0;
		int b = 10;
		
		// ������� ������ array � ��������� ���������� ������� � ���������
		int[] array = new int[size];
		array = createRandomMassiveInDiapason(array, a, b);
		
		//������� ������ ������ Massive
		Massive massive = new Massive();
		
		//��������� ������ ������ Massive ������� ��������� ���� array � ������ � �������� �������
		massive.printMassiveAsLine(array);
		massive.printReverseMassiveAsLine(array);
		
		//��������� ������ ������ Massive ������� ����� ��������� array 
		int sum = massive.getSumOfElements(array);
		System.out.println("����� ��������� ������� = " + sum);
		
		//��������� ������ ������ Massive �������� ��������� array �� 3
		array = massive.multiptyBy3(array);
		System.out.println("\n���������� ������ ����� ��������� ��������� �� 3:");
		
		//��������� ������ ������ Massive ������� ���������� ����� ��������� array � ������ � �������� �������
		massive.printMassiveAsLine(array);
		massive.printReverseMassiveAsLine(array);
	}

	public static int[] createRandomMassiveInDiapason(int[] mas, int a, int b) {
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (a + Math.random() * (b - a));
		}
		return mas;
	}

}

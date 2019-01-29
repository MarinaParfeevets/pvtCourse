package core;

import java.util.Scanner;

public class Task3_4 {
	public static void main(String[] args) {

		int n = 10;
		int num;
		int pow;
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.println("� ����� ������� ������ �������� �����? �������: ");
			pow = scan.nextInt();
			if (pow < 0) {
				System.out.println("������ ������������� ����� �����! ���������� ��� ���. ");
				continue;
			}
			num = (int) (Math.random() * n);
			System.out.println("����� " + num + " � " + pow + " ������� = " + powIntNumber(num, pow));
		}
		scan.close();
	}

	public static int powIntNumber(int a, int pow) {

		int res = 1;
		//for pow == 0 will return res = 1
		if (pow > 0) {
			for (int i = 1; i <= pow; i++) {
				res = res * a;
			}  
		}
		return res;
	}

}

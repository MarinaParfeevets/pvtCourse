package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2_14_extra {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>(100);// ������ names ����� ��������� �����������
		ArrayList<String> names1 = new ArrayList<>(100);// ���������������� ������ names1 ����� ��������� �������
		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ ������: ");
		int size_list = scan.nextInt();
		int n = 0;
		String s;
		String s1 = " �� ������."; 

		while (n < size_list) {
			System.out.print("������� " + (n + 1) + " ������� ������: ");
			s = scan.next();
			names.add(s);
			n++;
		}
		
		System.out.print("\n������: ");
		for (String str : names) {
			System.out.print(str + " ");
		}
		
		for (int i = 0; i < names.size(); i++) {
			s = names.get(i);
			names1.add(s + s1);
		}
		
		System.out.print("\n���������������� ������: ");
		for (String str : names1) {
			System.out.print(str + " ");
		}
		
		System.out.print("\n�������� ������ �����������: ");
		while (names.size() > 0) {
			names.remove(names.size()-1);
		}
		if (names.size() == 0) {
			System.out.print(" ������ ����!");
		}
		else {
			System.out.print(" ���! ���-�� ����� �� ���!");
		}
		for (String str : names) {
			System.out.print(str + " ");
		}
		
		System.out.print("\n�������� ������ �������: ");
		names1.clear();
		if (names1.size() == 0) {
			System.out.print(" ������ ����!");
		}
		else {
			System.out.print(" ���! ���-�� ����� �� ���!");
		}
		scan.close();
	}

}

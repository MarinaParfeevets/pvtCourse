package core_extra;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3_14_extra {

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
		printList(names);

		System.out.print("\n���������������� ������: ");
		names1 = changedList(names, s1);
		printList(names1);

		System.out.println("\n�������� ������ �����������: ");
		deleteAndPrintByElement(names);

		System.out.print("\n�������� ������ �������: ");
		removeList(names1);
		scan.close();
	}

	public static void printList(ArrayList<String> name) {

		for (String str : name) {
			System.out.print(str + " ");
		}
	}

	public static ArrayList<String> changedList(ArrayList<String> name, String str) {
		String s;
		int n = 100;
		ArrayList<String> name1 = new ArrayList<>(n);
		for (int i = 0; i < name.size(); i++) {
			s = name.get(i);
			name1.add(s + str);
		}
		return name1;
	}
	public static void deleteAndPrintByElement(ArrayList<String> name){
		while (name.size() > 0) {
			for (String str : name) {
				System.out.print(str + " ");
			}
			name.remove(name.size() - 1);
			System.out.println();
		}
		if (name.size() == 0) {
			System.out.print(" ������ ����!");
		} else {
			System.out.print(" ���! ���-�� ����� �� ���!");
		}
	}
	public static void removeList(ArrayList<String> name) {
		name.clear();
		if (name.size() == 0) {
			System.out.print("������ ����!");
		} else {
			System.out.print(" ���! ���-�� ����� �� ���!");
		}
	}
	
}

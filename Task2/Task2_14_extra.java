package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2_14_extra {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>(100);// список names будет удаляться поэлементно
		ArrayList<String> names1 = new ArrayList<>(100);// модифицированный список names1 будет удаляться целиком
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер списка: ");
		int size_list = scan.nextInt();
		int n = 0;
		String s;
		String s1 = " из списка."; 

		while (n < size_list) {
			System.out.print("Введите " + (n + 1) + " элемент списка: ");
			s = scan.next();
			names.add(s);
			n++;
		}
		
		System.out.print("\nСписок: ");
		for (String str : names) {
			System.out.print(str + " ");
		}
		
		for (int i = 0; i < names.size(); i++) {
			s = names.get(i);
			names1.add(s + s1);
		}
		
		System.out.print("\nМодифицированный список: ");
		for (String str : names1) {
			System.out.print(str + " ");
		}
		
		System.out.print("\nУдаление списка поэлементно: ");
		while (names.size() > 0) {
			names.remove(names.size()-1);
		}
		if (names.size() == 0) {
			System.out.print(" Список пуст!");
		}
		else {
			System.out.print(" Упс! Что-то пошло не так!");
		}
		for (String str : names) {
			System.out.print(str + " ");
		}
		
		System.out.print("\nУдаление списка целиком: ");
		names1.clear();
		if (names1.size() == 0) {
			System.out.print(" Список пуст!");
		}
		else {
			System.out.print(" Упс! Что-то пошло не так!");
		}
		scan.close();
	}

}

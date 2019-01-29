package core;

import java.util.Scanner;

public class Task2_5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите размер массива (целое положительное число): ");
		int size = scan.nextInt();
		scan.close();
		int[] mas = new int[size];
		int n =100;
		int k = 0;
		
		System.out.println("Массив: ");
		for (int i = 0; i <size; i++) {
			mas[i] = (int) (Math.random()*n);
			System.out.print(mas[i]+ " ");
			
		}
		System.out.print("\nПорядковые номера нулевых элементов: ");
		for (int i = 0; i <size; i++) {
			if (mas[i] == 0) {
				System.out.print((i + 1) + " ");
				k++;
			}
		}
		if (k == 0) {
			System.out.println("Нулевые элементы отсутствуют ");
		}
		
	}

}

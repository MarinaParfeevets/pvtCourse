package core;

import java.util.Scanner;

public class Task4_2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = 0;
		System.out.print("¬ведите размер массива (целое, положительное число): ");
		if (scan.hasNextInt()) {
			size = scan.nextInt();
		}
		scan.close();
		//диапазон чисел дл€ элементов массива
		int a = 0;
		int b = 10;
		
		// создаем массив array и заполн€ем рандомными данными в диапазоне
		int[] array = new int[size];
		array = createRandomMassiveInDiapason(array, a, b);
		
		//—оздать объект класса Massive
		Massive massive = new Massive();
		
		//»спользу€ методы класса Massive вывести созданный выше array в пр€мом и обратном пор€дке
		massive.printMassiveAsLine(array);
		massive.printReverseMassiveAsLine(array);
		
		//»спользу€ методы класса Massive вывести сумму элементов array 
		int sum = massive.getSumOfElements(array);
		System.out.println("—умма элементов массива = " + sum);
		
		//»спользу€ методы класса Massive умножить созданный array на 3
		array = massive.multiptyBy3(array);
		System.out.println("\n»змененный массив после умножени€ элементов на 3:");
		
		//»спользу€ методы класса Massive вывести полученный после умножени€ array в пр€мом и обратном пор€дке
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

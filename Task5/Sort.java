package core;

public class Sort {

	public static void main(String[] args) {
		int a = 0; // диапазон элементов массива
		int b = 20;
		int size = 7;
		int[] mas = new int[size];
		mas = createRandomMassive(mas, a, b);
		printMassive(mas);

		System.out.println();
		// сортировка вставкой
		int[] masInsert = mas;
		sortInsert(masInsert);
		printMassive(masInsert);
		System.out.println(" - сортировка вставкой");

		// сортировка слиянием
		int[] masMerge = mas;
		int length = mas.length - 1;
		sortMerge(masMerge, 0, length);
		printMassive(masMerge);
		System.out.println(" - cортировка слиянием");

		// сортировка Шелла
		sortShell(mas);
		printMassive(mas);
		System.out.println(" - сортировка Шелла");
	}

	// сортировка вставкой
	public static void sortInsert(int[] mas) {
		int temp, j;
		for (int i = 0; i < mas.length - 1; i++) {
			if (mas[i] > mas[i + 1]) {
				temp = mas[i + 1];
				mas[i + 1] = mas[i];
				j = i;
				while (j > 0 && temp < mas[j - 1]) {
					mas[j] = mas[j - 1];
					j--; 
				}
				mas[j] = temp;
			}
		}
	}

	// сортировка слиянием
	public static void sortMerge(int[] mas, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			sortMerge(mas, first, middle);
			sortMerge(mas, middle + 1, last);
			insertMerge(mas, first, middle, last);
		}
	}

	public static void insertMerge(int[] mas, int first, int middle, int last) {
		int n = last - first + 1;
		int[] Temp = new int[n];
		int i = first;
		int j = middle + 1;
		int k = 0;

		while (i <= middle || j <= last) {
			if (i > middle) {
				Temp[k++] = mas[j++];
			} else if (j > last) {
				Temp[k++] = mas[i++];
			} else if (mas[i] < mas[j]) {
				Temp[k++] = mas[i++];
			} else {
				Temp[k++] = mas[j++];
			}
		}
		for (j = 0; j < n; j++) {
			mas[first + j] = Temp[j];
		}
	}

	// сортировка Шелла
	public static void sortShell(int[] mas) {
		int j;
		for (int step = mas.length / 2; step > 0; step = step / 2) {
			for (int i = step; i < mas.length; i++) {
				int temp = mas[i];
				for (j = i; j >= step && mas[j - step] > temp; j = j - step) {
					mas[j] = mas[j - step];
				}
				mas[j] = temp;
			}
		}
	}

	public static int[] createRandomMassive(int[] mas, int a, int b) {
		for (int i = 0; i < mas.length; i++) {
			mas[i] = (int) (a + Math.random() * (b - a));
		}
		return mas;
	}

	public static void printMassive(int[] mas) {
		for (int i : mas) {
			System.out.print(i + " ");
		}
	}
}

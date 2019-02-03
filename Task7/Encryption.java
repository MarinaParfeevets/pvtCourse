package additional;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {

		int n = 0;
		Scanner sc = new Scanner(System.in);
		// input massive size
		System.out.println("Input massive size: ");
		n = Integer.parseInt(sc.nextLine());

		int len = n * n;

		// input string for encryption
		System.out.println("Input " + len + " symbols: ");
		String line = sc.nextLine();

		sc.close();

		char[][] mas = new char[n][n];
		mas = parseStringToMassive(line, n);
		printMassive(mas, "Massive:");

		// right rotation massive by 90 degree
		rotation90Degree(mas);
		printMassive(mas, "Step 1:");

		// replace strings (first and last, second and (n-1), etc)
		replaceLines(mas);
		printMassive(mas, "Step 2:");

		// replace columns (first to second, 3th to 4th, etc)
		replaceColumns(mas);
		printMassive(mas, "Step 3:");

		// Result string after spiral output
		String result = parseSpiralTostring(mas);
		System.out.println("Result encrypted string: " + result);
	}

	public static void printMassive(char[][] mas, String str) {
		System.out.println(str);
		int n = mas.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mas[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static char[][] parseStringToMassive(String str, int n) {
		char[][] mas = new char[n][n];
		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mas[i][j] = str.charAt(index);
				index++;
			}
		}
		return mas;
	}

	public static void rotation90Degree(char[][] mas) {
		int n = mas.length;
		char[][] newMas = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMas[j][n - i - 1] = mas[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mas[i][j] = newMas[i][j];
			}
		}
	}

	public static void replaceLines(char[][] mas) {
		int n = mas.length;
		char[] temp = new char[n];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				temp[j] = mas[i][j];
				mas[i][j] = mas[n - 1 - i][j];
				mas[n - 1 - i][j] = temp[j];
			}
		}
	}

	public static void replaceColumns(char[][] mas) {
		int n = mas.length;
		int step = 2;
		char[] temp = new char[n];
		for (int j = 0; j < n - 1; j += step) {
			for (int i = 0; i < n; i++) {
				temp[i] = mas[i][j];
				mas[i][j] = mas[i][j + 1];
				mas[i][j + 1] = temp[i];
			}
		}
	}

	public static String parseSpiralTostring(char[][] mas) {
		String result = "";
		int n = mas.length-1;
		int size =n+1;
		int i=0;
		int j = 0;
		int point = 1;
		int stepI=0;
		int stepJ=0;
		while (point <= size * size) {
			for ( j = stepI; j <= n-stepI; j++) {
				result += mas[stepI][j];
				point++;
			}
			for (i=stepJ+1;i<=n-stepJ;i++) {
				result += mas[i][n-stepJ];
				point++;
			}
			for (j=n-1-stepI; j>=stepI;j--) {
				result += mas[n-stepI][j];
				point++;
			}
			for (i=n-1-stepJ;i>stepJ;i--) {
				result += mas[i][stepJ];
				point++;
			}
			stepI++;
			stepJ++;
		}
		return result;
	}
}

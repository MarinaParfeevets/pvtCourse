package core;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Task7 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Input number of strings: ");
		int size = Integer.parseInt(scan.nextLine());

		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.println("Input string ¹ " + (i + 1) + ": ");
			array[i] = scan.nextLine();
		}
		scan.close();
		printTaskName("---All strings:---");
		printStringMassive(array);
		String sep = ", ";

		// the shortest and longest string
		printTaskName("---1. The shortest and longest string, their length:---");
		String line = maxStringLine(array);
		System.out.println(line + sep + line.length());
		line = minStringLine(array);
		System.out.println(line + sep + line.length());
		
		//sort strings
		printTaskName("---2. Decreasing sort by string's length:---");
		String[] sortArr = decreasingSort(array);
		printStringMassive(sortArr);

		// Strings with length less than average length
		printTaskName("---3. Strings with length less than average:---");
		printStrWithLengthLessAverage(array);

		// The word with minimum various chars
		printTaskName("---4. The first word with minimum various chars:---");
		printWordWithMinVariousChars(array);

		// Count of words with latin chars only and equals of vowels and consonants
		printTaskName("---5. Count of words with latin chars only and equals of vowels and consonants:---");
		printWordWithEqualsVowConsChars(array);

		// The first word, which chars go in a strict order of increasing their codes
		printTaskName("---6. The first word, which chars  go in a strict order of increasing their codes:---");
		printWordStrictOrderOfHashcode(array);

		// The fist word with all various chars
		printTaskName("---7. The word with all various chars:---");
		printWordWithAllVariousChars(array);

		// Find digit palindrom, print second word
		printTaskName("---8. Find digit palindrom. If such a few print the second:---");
		System.out.println(findSecondDigitPalidrom(array));
	}

	public static void printTaskName(String str) {
		System.out.println();
		System.out.println(str);
	}

	public static void printStringMassive(String[] mas) {
		for (String str : mas) {
			System.out.println(str);
		}
	}

	// 1 task
	public static String maxStringLine(String[] mas) {
		String maxStr = mas[0];
		for (String str : mas) {
			if (str.length() > maxStr.length()) {
				maxStr = str;
			}
		}
		return maxStr;
	}

	public static String minStringLine(String[] mas) {
		String minStr = mas[0];
		for (String str : mas) {
			if (str.length() < minStr.length()) {
				minStr = str;
			}
		}
		return minStr;
	}

	// 2 task
	public static String[] decreasingSort(String[] mas) {
		String temp;
		int j;
		for (int i = 0; i < mas.length - 1; i++) {
			if (mas[i + 1].length() > mas[i].length()) {
				temp = mas[i + 1];
				mas[i + 1] = mas[i];
				j = i;
				while (j > 0 && temp.length() > mas[j - 1].length()) {
					mas[j] = mas[j - 1];
					j--;
				}
				mas[j] = temp;
			}
		}
		return mas;
	}

	// 3 task
	public static void printStrWithLengthLessAverage(String[] array) {
		double av = 0f;
		for (String s : array) {
			av += (double) s.length();
		}
		final double average = av / array.length;
		System.out.println("Average length = " + average);
		List<String> list = Arrays.asList(array).stream().filter(str -> (str.length() < average))
				.collect(Collectors.toList());
		list.stream().forEach(str -> System.out.println(str + ", length: " + str.length()));
	}

	// 4 task
	public static void printWordWithMinVariousChars(String[] array) {

		String min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (findCountDist(array[i]) < findCountDist(min)) {
				min = array[i];
			}
		}
		System.out.println(min + "; count of different chars: " + findCountDist(min));
	}

	private static long findCountDist(String str) {
		return (str.chars().distinct().count());
	}

	// 5 task
	public static void printWordWithEqualsVowConsChars(String[] arr) {
		int len = arr.length;
		String str[] = new String[len];
		int count = 0;
		int k = 0;
		for (int i = 0; i < len; i++) {// create massive with latin chars' words 
			str[k] = "";
			if (regular(arr[i], "[a-zA-Z]+")) {
				for (int j = 0; j < arr[i].length(); j++) {
					str[k] = str[k] + (arr[i].charAt(j));
				}
				k++;
				count++;
			}
		}

		int countDiff = 0;
		int vowIn = 0;
		System.out.println("Count of words with only latin chars: " + count);
		char[] vowels = { 'A', 'E', 'Y', 'U', 'I', 'O', 'e', 'y', 'u', 'i', 'o', 'a' };
		for (int i = 0; i < count; i++) {// count of words
			int vow = 0;
			int cons=0;
			for (int j = 0; j < str[i].length(); j++) {// count of chars in word
				for (int z = 0; z < vowels.length; z++) { // massive of vowels chars
					if (vowels[z] == str[i].charAt(j)) {
						vowIn++;
						break;
					}
				}
				if (vowIn == 0) {
					cons++;
				} else {
					vow++;
					vowIn = 0;
				}
			}
			if (vow == cons) {
				countDiff++;
			}
		}
		System.out.println("Count of words with equals of vowels and consonants: " + countDiff);
	}

	// task 6
	public static void printWordStrictOrderOfHashcode(String[] arr) {
		int len = arr.length;
		int count = 0;
		int i = 0;
		while (i < len && count < 1) {
			for (int j = 0; j < arr[i].length() - 1; j++) {
				if (arr[i].codePointAt(j) > arr[i].codePointAt(j + 1)) {
					count = 0;
					break;
				}
				count++;
			}
			i++;
		}
		System.out.println("First one: " + arr[i - 1]);
	}

	private static boolean regular(String str, String reg) {
		return str.matches(reg);
	}

	// 7 task
	public static void printWordWithAllVariousChars(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (findCountDist(arr[i]) == arr[i].length()) {
				System.out.println("First one: " + arr[i]);
				break;
			}
		}
	}

	// 8 task
	public static String findSecondDigitPalidrom(String[] arr) {
		String pal = "";
		int count = 0;
		int i = 0;
		while (i < arr.length && count < 2) {
			if (isDigitPalindrom(arr[i])) {
				pal = arr[i];
				count++;
			}
			i++;
		}
		return count == 0 ? "There are no one digit palindrom!" : pal;
	}

	private static boolean isDigitPalindrom(String str) {
		boolean res = true;
		int len = str.length();
		int i = 0;
		String strReg = "[0-9]+";

		while (i < len / 2) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				res = false;
				break;
			}
			i++;
		}
		return (regular(str, strReg) ? res : false);
	}
}

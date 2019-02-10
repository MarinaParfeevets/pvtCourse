package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task10 {
	static Scanner scan;

	public static void main(String[] args) throws FileNotFoundException {

		scan = new Scanner(System.in);
		int n = getOrder();

		String str;
		System.out.println("Please, type '1' to input text from console, any other char to load text from file.");
		scan = new Scanner(System.in);
		String check = scan.nextLine();
		int k = check.equals("1") ? 1 : 0;

		switch (k) {
		case 1:
			str = getTextFromConsole();
			break;
		default:
			System.out.println("Text will be load from file 'D:\\text.txt'.");
			str = getTextFromFile();
			System.out.println(str);
			break;
		}

		Word w = new Word(str, n);
		// The first way to output modified text
		w.printText();
		// The second way to output modified text
		w.printTitleOfOperation("Modified text: (the second way)");
		System.out.println(w.replaceSymbolInText());

		Paragraph sen = new Sentence(str, n);
		// output modified string line
		sen.printTitleOfOperation("Modified string line:");
		System.out.println(sen.replaceSymbolInStringLine());

		Sentence word = new Word(str, n);
		// output of list of sentences
		word.printTitleOfOperation("List of all sentences:");
		word.printAllSentence();

		// call static method
		System.out.println(Paragraph.replaceSymbolInStringLine(str, n));

	}

	public static int getOrder() {
		scan = new Scanner(System.in);
		while (true) {
			System.out.println("Order of letter which will be replaced by '%': ");
			if (scan.hasNextInt()) {
				int input = scan.nextInt();
				if (input > 0) {
					return input;
				}
			}
			System.out.println("Incorrect input. Please, try again!");
			scan.nextLine();
		}
	}

	public static String getTextFromConsole() {

		scan = new Scanner(System.in);
		String str = "";
		String s = "";
		int flag = 7; // size of 'exit' + 2 symbols'\r\n'+1 symbol of string (size-order)
		System.out.println("Input text: (Type 'exit' to stop input.)");
		do {
			s = scan.nextLine();
			str += s + "\r\n";
		} while (!s.equals("exit"));
		return str.substring(0, str.length() - flag);
	}

	public static String getTextFromFile() {
		String s = "";
		try {
			scan = new Scanner(new File("D:\\text.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Please, check the path to the file!");
		}
		while (scan.hasNext())
			s += scan.nextLine() + "\r\n";
		scan.close();
		return s;
	}
}

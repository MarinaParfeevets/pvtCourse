package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
	public static void main(String[] args) {

		System.out.println(test1("pizz"));
		System.out.println(test2("rt"));
	}

	// регулярное выражение, которое проверит, что в заданной строке содержится
	// не более 4-х букв латинского алфавита.
	public static boolean test1(String testString) {
		Pattern p = Pattern.compile("[a-zA-Z]{0,4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}

	// регулярное выражение, которое проверит, что в заданной строке содержится
	// ровно 4 любых символа
	public static boolean test2(String testString) {
		Pattern p = Pattern.compile(".{4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}
}

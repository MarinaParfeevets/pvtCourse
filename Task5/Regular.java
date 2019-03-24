package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
	public static void main(String[] args) {

		System.out.println(test1("pizz"));
		System.out.println(test2("rt"));
	}

	// ���������� ���������, ������� ��������, ��� � �������� ������ ����������
	// �� ����� 4-� ���� ���������� ��������.
	public static boolean test1(String testString) {
		Pattern p = Pattern.compile("[a-zA-Z]{0,4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}

	// ���������� ���������, ������� ��������, ��� � �������� ������ ����������
	// ����� 4 ����� �������
	public static boolean test2(String testString) {
		Pattern p = Pattern.compile(".{4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}
}

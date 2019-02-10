package core;

public interface Text {
	char symbol = '%';

	void printText();

	default void printTitleOfOperation(String str) {
		System.out.println(str);
	}
}

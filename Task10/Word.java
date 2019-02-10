package core;

public class Word extends Sentence {

	public Word(String str, int n) {
		super(str, n);
	}

	public String replaceSymbolInText() {
		String text;
		String result = "";
		String[] line = super.str.split("\r\n");
		for (int i = 0; i < line.length; i++) {
			text = replaceSymbolInStringLine(line[i], super.n);
			result += text + "\r\n";
		}
		return result;
	}

	@Override
	public void printText() {
		printTitleOfOperation("Modified text:");
		System.out.println(replaceSymbolInText());
	}

}

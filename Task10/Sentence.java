package core;

import java.util.Iterator;
import java.util.LinkedList;

public class Sentence extends Paragraph {
	private LinkedList<String> sentences;

	public Sentence(String str, int n) {
		super(str, n);
		sentences = new LinkedList<>();
	}

	public void printAllSentence() {
		divideText();
		Iterator<String> it = sentences.iterator();
		int i = 1;
		int offset = 2;
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("\r")) {
				break;
			}
			if (s.substring(0, offset) == "\r\n") {
				s = s.substring(offset);

			}

			System.out.println(i + " sentence is: " + s.trim());
			i++;
		}
	}

	@Override
	protected void divideText() {
		for (String s : super.str.split("\\.|!|\\?")) {
			sentences.add(s);
		}
	}

	@Override
	public void printText() {
		printTitleOfOperation("List of sentences:");
		this.printAllSentence();
	}
}

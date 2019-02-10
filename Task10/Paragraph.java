package core;

public abstract class Paragraph implements Text {
	protected String str;
	protected int n;

	public Paragraph() {

	}

	public Paragraph(String str, int n) {
		this.str = str;
		this.n = n;
	}

	protected abstract void divideText();

	@Override
	public void printText() {
		System.out.println(str);

	}

	public static String replaceSymbolInStringLine(String str, int n) {
		StringBuilder sb = new StringBuilder();
		if (str != null && str.length() > 0) {
			for (String s : str.split(" ")) {

				if (s.length() >= n) {
					sb.append(s.substring(0, n - 1)).append(symbol).append(s.substring(n, s.length()));
				} else {
					sb.append(s);
				}
				sb.append(" ");

			}
		}
		return sb.toString();
	}

	public String replaceSymbolInStringLine() {
		return replaceSymbolInStringLine(str, n);
	}
}

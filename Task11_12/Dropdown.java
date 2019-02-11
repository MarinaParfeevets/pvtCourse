package core;

import java.util.List;

public class Dropdown {
	private List<String> options;
	private boolean isSelected;
	private String name;

	public Dropdown(List<String> options, boolean isSelected, String name) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}

	public String toString() {
		String str = "";
		String space = " ";
		for (String s : options) {
			str = str + space + s;
		}
		return "{ "+str + " } " + this.isSelected +space+ this.name;
	}
}

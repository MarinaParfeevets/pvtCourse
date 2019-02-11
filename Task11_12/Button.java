package core;

public class Button {
	private String name;
	private String action;

	public Button(String name, String action) {
		this.name = name;
		this.action = action;
	}



	public String toString() {
		return this.name + " " + this.action;
	}
}

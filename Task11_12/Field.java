package core;

public class Field {
	private int id;
	private String value;

	public Field(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public String toString() {
		return this.id + " " + this.value;
	}
}

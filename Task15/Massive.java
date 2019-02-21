package core;

public class Massive {
	private int[] mas;
	private int number;
	private String str;

	public Massive() {

	}

	public Massive(int[] mas, int number) {
		this.mas = mas;
		this.number = number;
	}

	public Massive(int[] mas, int number, String str) {
		this(mas, number);
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int[] getMas() {
		return mas;
	}

	public void setMas(int[] mas) {
		this.mas = mas;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean equals(int[] masSecond) {
		int n = masSecond.length;
		if (mas.length != masSecond.length) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (mas[i] != masSecond[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] reverse() {
		int n = mas.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = mas[n - i - 1];
		}
		return result;
	}

	public int getSumOfElements() {
		int n = mas.length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = result + mas[i];
		}
		return result;
	}

	public boolean equalMaxToNumber() {
		int max = this.maxElement();
		return max == this.number ? true : false;
	}

	public int maxElement() {
		int n = mas.length;
		int result = mas[0];
		for (int i = 1; i < n; i++) {
			if (mas[i] > result) {
				result = mas[i];
			}
		}
		return result;
	}

	public int[] decreaseTo(int a) {
		if (a == 0) {
			throw new ArithmeticException();
		}
		int n = mas.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = mas[i] / a;
		}
		return result;
	}
}

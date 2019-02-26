package core;

public class Massive {
	private int[] mas;
	private String str;

	public Massive() {

	}

	public Massive(int[] mas) {
		this.mas = mas;
	}

	public Massive(int[] mas, String str) {
		this(mas);
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

	public boolean isEquals(int[] masSecond) {
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

	public boolean isEqualMaxToNumber(int number) {
		int max = this.maxElement();
		return max == number;
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

	public int getFifthElement() {
		int n = 4;
		if (mas.length < n) {
			throw new IndexOutOfBoundsException();
		}
		return mas[n];
	}

	public int getSize() {
		return mas.length;
	}

	public int[] increaseTo(int a) {
		int n = mas.length;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = mas[i] + a;
		}
		return result;
	}

	public String newString(String s) {
		return this.str + s;
	}
}

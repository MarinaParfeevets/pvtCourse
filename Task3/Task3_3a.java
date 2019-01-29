package core;

public class Task3_3 {

	public static void main(String[] args) {

		int n = 10;
		int num;
		for (int i = 1; i <= 5; i++) {
			num = (int) (Math.random() * n);
			System.out.println("Число " + num + " в квадрате = " + squareNumber(num));
		}
	}

	public static int squareNumber(int a) {

		int res =(int)( Math.pow(a, 2));
		return res;
	}
}

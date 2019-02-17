package core;

public class Task13 {

	public static void main(String[] args) {
		Massive mas = new Massive(-3, 4);
		Massive massive = new Massive(3, 4);
		massive.createStrangeRandomMassive();
		massive.changedMassive();
		double y = Massive.inputDouble();
		System.out.println(y);
		massive.inputSizeN();
		massive.elementXYIndexDivisionByValueAnotherSumValue(2, -1, 5);
		massive.methodWithoutLogic();
	}

}

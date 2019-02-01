package additionalExtra;

public class MainAdditionalExtra {

	public static void main(String[] args) {

		int age = 25;
		String name = "Ani";

		// we can't create object cause the constructor TesterAdditionalExtra() is
		// private and isn't visible from others classes. Next code generates exception:
		TesterAdditionalExtra tester = new TesterAdditionalExtra();

		// but we can use static methods of class TesterAdditionalExtra. It makes
		// possible to generate methods without creating object. for example:
		TesterAdditionalExtra.setAge(age);
		TesterAdditionalExtra.setName(name);

	}

}

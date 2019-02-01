package core;

public class MainTesterClass {

	public static void main(String[] args) {

		String name = "Lesya";
		String surname = "Gorina";
		int expirienceInYears = 5;
		String englishLevel = "B1";
		int salary = 1500;

		// 1. initialization
		Tester tester = new Tester(name, surname, expirienceInYears, englishLevel, salary);

		// 2. output using getters-methods, methods are visible inside package
		System.out.println(tester.getName());
		System.out.println(tester.getSurname());
		System.out.println(tester.getExpirienceInYears());
		System.out.println(tester.getEnglishLevel());
		System.out.println(tester.getSalary());

		// input using setters-methods, methods are visible inside package
		tester.setName(name);
		tester.setSurname(surname);
		tester.setExpirienceInYears(expirienceInYears);
		tester.setEnglishLevel(englishLevel);
		tester.setSalary(salary);

		// 3. Tester class private method (increaseSalaryByTwo) impossible to use in
		// another classes (only in class Tester)
		System.out.println(tester.increaseSalaryByTwo());

		// 4. default(friendly) method (expirienceInMonth) we can use in package
		System.out.println(tester.expirienceInMonth());

		// 5. protected method (printNameSurname) we can use in package and child
		// classes)
		tester.printNameSurname();

		// 6. public method visible everywhere
		tester.printAllInformation();

	}

}

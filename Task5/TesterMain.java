package core;

public class TesterMain {

	public static void main(String[] args) {

		Tester tester1 = new Tester("Bob", "Adams");
		Tester tester2 = new Tester("Anna", "Kirk", 10, "B1");
		Tester tester3 = new Tester("Max", "Grid", 5, "A1", 589.9);

		String emptyChar = " ";
		System.out.println(
				tester1.getName() + emptyChar + tester1.getSurname() + emptyChar + tester1.getExpirienceInYears()
						+ emptyChar + tester1.getEnglishLevel() + emptyChar + tester1.getSalary());
		System.out.println(
				tester2.getName() + emptyChar + tester2.getSurname() + emptyChar + tester2.getExpirienceInYears()
						+ emptyChar + tester2.getEnglishLevel() + emptyChar + tester2.getSalary());
		System.out.println(
				tester3.getName() + emptyChar + tester3.getSurname() + emptyChar + tester3.getExpirienceInYears()
						+ emptyChar + tester3.getEnglishLevel() + emptyChar + tester3.getSalary());

		System.out.println();

		// вызов перегруженных методов
		tester1.setAndPrintInformation("Marina", "Parfeevets");
		tester2.setAndPrintInformation("Sergej", "Popov", 9, "A1");
		tester3.setAndPrintInformation("Anna", "Taranova", 24, "B2", 1234.6);

		System.out.println();

		int expirienceInYears = 5;
		String englishLevel = "A2";

		// вызов статического метода, который провер€ет подходит ли кандидат по стажу
		// (>=4 года) и знанию английского €зыка (уровень выше B1)
		boolean check = Tester.checkTesterQualification(expirienceInYears, englishLevel);

		String message = " андидат со стажем %s лет(года) и уровнем английского €зыка %s на должность ";
		String str = String.format(message, expirienceInYears, englishLevel);

		if (check) {
			System.out.println(str + "подходит!");
		} else {
			System.out.println(str + "не подходит!");
		}
	}

}

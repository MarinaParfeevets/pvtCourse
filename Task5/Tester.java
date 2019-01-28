package core;

public class Tester {
	public String name;
	public String surname;
	public int expirienceInYears;
	public String englishLevel;
	public Double salary;

	public Tester() {
	}

	public Tester(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel, Double salary) {
		this(name, surname, expirienceInYears, englishLevel);
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getExpirienceInYears() {
		return this.expirienceInYears;
	}

	public String getEnglishLevel() {
		return this.englishLevel;
	}

	public Double getSalary() {
		return this.salary;
	}

	// перегруженные методы set с выводом на печать
	public void setAndPrintInformation(String name, String surname) {
		this.name = name;
		this.surname = surname;
		String emptyChar = " ";
		System.out.println("»м€ и фамили€ сотрудника: ");
		System.out.println(name + emptyChar + surname);
	}

	public void setAndPrintInformation(String name, String surname, int expirienceInYears, String englishLevel) {
		this.name = name;
		this.surname = surname;
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
		String emptyChar = ", ";
		System.out.println("»нформаци€ о сотруднике (им€, фамили€, опыт работы, знание английского €зыка): ");
		System.out.println(name + emptyChar + surname + emptyChar + expirienceInYears + emptyChar + englishLevel);
	}

	public void setAndPrintInformation(String name, String surname, int expirienceInYears, String englishLevel,
			Double salary) {
		this.name = name;
		this.surname = surname;
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
		this.salary = salary;
		String emptyChar = ", ";
		System.out.println("¬с€ информаци€ о сотруднике: ");
		System.out.println(name + emptyChar + surname + emptyChar + expirienceInYears + emptyChar + englishLevel
				+ emptyChar + salary);
	}

	// статический метод , который провер€ет подходит ли кандидат по стажу (>=4
	// года) и знанию английского €зыка (уровень выше B1)
	public static boolean checkTesterQualification(int expirienceInYears, String englishLevel) {
		switch (englishLevel) {
		case "B2":
		case "C1":
		case "C2":
			break;
		default:
			return false;
		}
		if (expirienceInYears >= 4) {
			return true;
		} else {
			return false;
		}
	}
}

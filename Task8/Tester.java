package core;

public class Tester {
	public String name;
	public String surname;
	int expirienceInYears;
	protected String englishLevel;
	private int salary;

	Tester(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	Tester(String name, String surname, int expirienceInYears, String englishLevel) {
		this(name, surname);
		this.expirienceInYears = expirienceInYears;
		this.englishLevel = englishLevel;
	}

	public Tester(String name, String surname, int expirienceInYears, String englishLevel, int salary) {
		this(name, surname, expirienceInYears, englishLevel);
		this.salary = salary;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExpirienceInYears() {
		return expirienceInYears;
	}

	void setExpirienceInYears(int expirienceInYears) {
		this.expirienceInYears = expirienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	private int increaseSalaryByTwo() {
		int n = 2;
		return (salary * n);
	}

	int expirienceInMonth() {
		int months = 12;
		return expirienceInYears * months;
	}

	protected void printNameSurname() {
		String mess = "Name: %s, Surname: %s";
		String str = String.format(mess, name, surname);
		System.out.println(str);
	}

	public void printAllInformation() {
		String emptyChar = " ";
		System.out.println(name + emptyChar + surname + emptyChar + expirienceInYears + emptyChar + englishLevel
				+ emptyChar + salary);
	}

}

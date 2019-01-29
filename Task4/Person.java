package core;

public class Person {
	String name;
	String surname;
	int age;
	String phone;

	public Person() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String sname) {
		this.surname = sname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void printAllInformation() {
		char emptyChar = ' ';
		System.out.print("Вся информация: ");
		System.out.println(getName() + emptyChar + getSurname() + emptyChar + getAge() + emptyChar + getPhone());
	}

	public void printName() {
		char emptyChar = ' ';
		System.out.print("Имя и Фамилия: ");
		System.out.println(getName() + emptyChar + getSurname());
	}

	public boolean isAdult() {
		if (this.age >= 18) {
			return true;
		} else {
			return false;
		}
	}
}

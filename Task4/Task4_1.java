package core;

import java.util.Scanner;

public class Task4_1 {

	public static void main(String[] args) {
		String name;
		String surname;
		int age;
		String phone;

		Scanner scan = new Scanner(System.in);

		// вводим информацию о person с клавиатуры
		System.out.print("Введите имя: ");
		name = scan.next();

		System.out.print("Введите фамилию: ");
		surname = scan.next();

		System.out.print("Введите вoзраст: ");
		age = scan.nextInt();

		System.out.print("Введите номер телефона: ");
		phone = scan.next();

		scan.close();
		
		Person person = new Person();

		// инициализируем объект введенными данными
		person.setName(name);
		person.setSurname(surname);
		person.setAge(age);
		person.setPhone(phone);

		// вывести всю информацию о person
		person.printAllInformation();

		// вывести имя и фамилию
		person.printName();

		// узнать взрослый ли человек (>=18 это взрослый)
		if (person.isAdult()) {
			System.out.println("Взрослый!");
		} else {
			System.out.println("Пока еще ребенок!");
		}
	}

}

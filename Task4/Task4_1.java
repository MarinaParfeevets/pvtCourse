package core;

import java.util.Scanner;

public class Task4_1 {

	public static void main(String[] args) {
		String name;
		String surname;
		int age;
		String phone;

		Scanner scan = new Scanner(System.in);

		// ������ ���������� � person � ����������
		System.out.print("������� ���: ");
		name = scan.next();

		System.out.print("������� �������: ");
		surname = scan.next();

		System.out.print("������� �o�����: ");
		age = scan.nextInt();

		System.out.print("������� ����� ��������: ");
		phone = scan.next();

		scan.close();
		
		Person person = new Person();

		// �������������� ������ ���������� �������
		person.setName(name);
		person.setSurname(surname);
		person.setAge(age);
		person.setPhone(phone);

		// ������� ��� ���������� � person
		person.printAllInformation();

		// ������� ��� � �������
		person.printName();

		// ������ �������� �� ������� (>=18 ��� ��������)
		if (person.isAdult()) {
			System.out.println("��������!");
		} else {
			System.out.println("���� ��� �������!");
		}
	}

}

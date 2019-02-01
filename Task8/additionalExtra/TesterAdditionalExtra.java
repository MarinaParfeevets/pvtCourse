package additionalExtra;

public class TesterAdditionalExtra {
	static int age;
	static String name;
	
	//private constructor prohibits to create an object
	private TesterAdditionalExtra() {

	}
	
	//static methods allow to use them without instance
	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		TesterAdditionalExtra.age = age;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		TesterAdditionalExtra.name = name;
	}

	
	
}

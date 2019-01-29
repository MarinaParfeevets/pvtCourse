package Task1_4;

public class Task1_4 {

	public static void main(String[] args) {
		
		int a = 10;
		short sh = 3;
		long dl = 8L;  
		double dd = 345.9d;
		float fl = 2.45f;
		char ch = 'y';
		boolean bool = true;
		
		int result1 = 0;
		double result2 = 0;
		double result3 = 0;
		boolean result4 = false; 
		boolean result5 = false;
		boolean result6 = false;
		boolean result7 = false;
		
		result1 = a + sh;
		result2 = dl - dd;
		result3 = dd * fl;
		if (dl > dd) {
			result4 = true;
		} 
		if (fl < a) {
			result5 = true;
		}
		if (a == sh) {
			result6 = true;
		}
		if (fl != dd) {
			result7 = true;
		}
		
		System.out.print("Переменные всех типов: "+ "\t");
		System.out.println(a+" "+ sh+" "+ dl+" "+ dd+" "+ fl+" "+ ch+" "+ bool);
		System.out.println("1.Cумма int и short: "+ a+" + "+sh+" = "+ result1);
		System.out.println("2.Разность long и double: "+ dl+" - "+dd+" = "+ result2);
		System.out.println("3.Произведение float и double: "+ fl+" * "+dd+" = "+ result3);
		System.out.println("4.Результат сравнения long > double: "+ dl+" > "+dd+" : "+ result4);
		System.out.println("5.Результат сравнения float < int: "+ fl+" < "+a+" : "+ result5);
		System.out.println("6.Результат сравнения на равенство int и short: "+ a+" равно "+sh+" : "+ result6);
		System.out.println("7.Результат сравнения на неравенство float и  double: "+ fl+" не равно "+dd+" : "+ result7);
	}

}

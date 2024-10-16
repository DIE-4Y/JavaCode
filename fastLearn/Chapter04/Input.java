import java.util.Scanner;


public class Input{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		String name = myscanner.next();
		int  age = myscanner.nextInt();
		double salary = myscanner.nextDouble();
		System.out.print("name " + name + "age "+ age + "salary " + salary);
	}
}
import java.util.Scanner;
public class If1{
	public static void main(String[] args) {
		System.out.println("������num1��num2��");
		Scanner myscanner =  new Scanner(System.in);
		double num1 = myscanner.nextDouble();
		double num2 = myscanner.nextDouble();
		if (num1 > 10 && num2 < 20){
			System.out.println(num1+num2);
		}
	}
}
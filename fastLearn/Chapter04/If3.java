import java.util.Scanner;
public class If3{
	public static void main(String[] args){
		System.out.println("input year :");
		Scanner myscanner= new Scanner(System.in);
		int year = myscanner.nextInt();
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			System.out.println("it's runyear!");
		}else{
			System.out.println("it's not!");
		}
	}
}
import java.util.Scanner;


public class HomeWork04 {
	public static void main(String[] args){
		System.out.println("input a 3 weight number:>");
		Scanner myScanner = new Scanner(System.in);
		int num = myScanner.nextInt();
		int sum = 0;
		int g = num % 10;
		int s = (num / 10) % 10;
		int b = (num / 100) % 10;
		sum = g*g*g + s*s*s + b*b*b;
		if (num == sum){
			System.out.println("it's flower number");
		}else {
			System.out.println("it's not flower number");
		}

	}
}
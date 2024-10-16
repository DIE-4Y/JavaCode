import java.util.Scanner;


public class HomeWork04 {
	public static void main(String[] args){
		System.out.println("input a 3 weight number:>");
		Scanner myScanner = new Scanner(System.in);
		int num = myScanner.nextInt();
		int sum = 0, num1 = num;
		for (int i = 0; i <= 3; i++) {
			int temp += num % 10;
			sum += temp * temp * temp;
			num /= 10;
		}
		if (num1 == sum){
			System.out.println("it's flower number");
		}else {
			System.out.println("it's not flower number");
		}

	}
}
import java.util.Scanner;

public class HomeWork02 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("input a interge:>");
		int num = myScanner.nextInt();
		if (num > 0) {
			System.out.println("it > 0");
		}else if (num == 0) {
			System.out.println("it = 0");
		}else {
			System.out.println("it < 0");
		}
	}
}
import java.util.Scanner;
public class If2{
	public static void main(String[] args) {
		Scanner myscanner = new Scanner(System.in);
		int num = myscanner.nextInt();
		if ((num % 3 == 0) && (num % 5 == 0)){
			System.out.println("it can be zhengchu!");
		}else{
			System.out.println("it can't!");
		}
	}
}
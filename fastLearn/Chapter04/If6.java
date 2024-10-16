import java.util.Scanner;
public class If6{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("input month:>");
		int month = myscanner.nextInt();
		System.out.println("input your age:>");
		int age = myscanner.nextInt();
		if (month < 4 || month > 10){
			if (age < 18){
				System.out.println("20!");
			}
			else{
				System.out.println("40!");
			}
		}else{
			if(age < 18){
				System.out.println("30!");
			}else if (age > 60){
				System.out.println("20!");
			}else{
				System.out.println("60!");
			}
		}
	}
}
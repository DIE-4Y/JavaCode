import java.util.Scanner;

public class If5{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		double grade = myscanner.nextDouble();
		char gender = myscanner.next().charAt(0);
		if (grade < 8.0){
			System.out.println("losser!");
		}else{
			if (gender == 'f'){
				System.out.println("famale group!");
			}else if(gender == 'm') {
				System.out.println("male group!");
			}else{
				System.out.println("SB!");
			}
		}
	}
}
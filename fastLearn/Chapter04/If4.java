import java.util.Scanner;

public class If4{
	public static void main(String[] args){
		System.out.println("input id credit:>");
		Scanner myscanner = new Scanner(System.in);
		int credit = myscanner.nextInt();
		if (credit < 0 || credit >= 100){
			System.out.println("data error!");
		}else{
			if(credit > 90){
				System.out.println("good!");
			}else if (credit <=90 && credit > 80){
				System.out.println("not bad!");
			}else {
				System.out.println("asshole!");
			}
		}
		
	}
}
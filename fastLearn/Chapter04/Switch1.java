import java.util.Scanner;

public class Switch1{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		// System.out.println("input a-e:>");
		// char c = myscanner.next().charAt(0);
		// switch(c){
		// 	case 'a':
		// 		System.out.println("A");break;
		// 	case 'b':	
		// 		System.out.println("B");break;
		// 	case 'c':
		// 		System.out.println("C");break;
		// 	case 'd':
		// 		System.out.println("D");break;
		// 	case 'e':
		// 		System.out.println("E");break;
		// 	default:
		// 		System.out.println("other");break;
		// }
		// System.out.println("input score:>");
		// double score = myscanner.nextDouble();
		// if (score >= 0 && score <= 100){
		// 	switch((int)(score/60)) {
		// 		case 1:
		// 			System.out.println("overemean!");
		// 		case 0:
		// 			System.out.println("lower");	
		// 	}
		// }else{
		// 	System.out.println("not in range(0-100)");
		// }
		System.out.println("input month:>");
		int month = myscanner.nextInt();
		switch(month) {
			case 1:
			case 2:
			case 3:
				System.out.println("spring");break;
			case 4:
			case 5:
			case 6:
				System.out.println("summer");break;
			case 7:
			case 8:
			case 9:
				System.out.println("fall");break;
			case 10:
			case 11:
			case 12:
				System.out.println("winter");break;
			default:
				System.out.println("out of range(1-12)");break;
		}
	}
}
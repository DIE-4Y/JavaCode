import java.util.Scanner;


public class Break01 {
	public static void main(String[] args) {
		 Scanner myScanner = new Scanner(System.in);
		int n = 3;
		for(int i = n-1; i >= 0; i--) {
			String name = myScanner.next();
			String password = myScanner.next();
			if ("dingzhen".equals(name) && "666".equals(password)) {
				System.out.println("login succsessfuly!");
				break;
			}else{
				System.out.println("you can try " + i + "again");
			}
		}
	}
}
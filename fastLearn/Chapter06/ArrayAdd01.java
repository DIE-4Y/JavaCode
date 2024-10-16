import java.util.Scanner;


public class ArrayAdd01 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int array[] = {1, 2, 3, 4, 5};
		do{
			int len = array.length;
			if(len == 1) {
				System.out.println("can't delete");
				break;
			}
			System.out.println("delete last num ? y/n");
			char ch = myScanner.next().charAt(0);
			if (ch == 'n') {
				break;
			}
			int newArray[] = new int[len - 1];
				for (int i = 0; i < len - 1; i++) {
					newArray[i] = array[i];
				}
				array = newArray;
		}while(true);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
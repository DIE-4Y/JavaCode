

public class Dowhile{
	public static void main(String[] args) {
		int start = 1, end = 200, t = 5, k = 3;
		int count = 0;
		do{
			start++;
			if ((start % 5 == 0) && (start % 3 != 0)){
				System.out.println(start);
			}			
		}while(start < end);
	}
}
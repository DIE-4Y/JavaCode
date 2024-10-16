

public class For2{
	public static void main(String[] args) {
		// int i = 1, n = 100, t = 3;
		// while(i <= n) {
		// 	if (i % t == 0){
		// 		System.out.println(i);
		// 	}
		// 	i++;
		// }
		int start = 40, end = 200, m = 2;
		while(start <= end) {
			start++;
			if (start % m == 0){
				System.out.println(start);
			}
		}
	}
}
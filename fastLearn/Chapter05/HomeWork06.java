public class HomeWork06 {
	public static void main(String[] args) {
		int start = 1, end = 100, count = 0;
		for (; start <= end; start++) {
			if (start % 5 != 0) {
				System.out.print(start + " ");
				count++;
			}
			if (count % 5 == 0) {
				System.out.println();
			}
		}
	}
}
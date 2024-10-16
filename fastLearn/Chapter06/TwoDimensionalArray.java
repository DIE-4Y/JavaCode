public class TwoDimensionalArray {
	public static void main(String[] args) {
		/*
		different alloc space
		*/
		int n = 10;
		int [][] array = new int [n][];//only define hang
		for (int i = 0; i < array.length; i++ ) {
			array[i] = new int [i + 1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = i+1;
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
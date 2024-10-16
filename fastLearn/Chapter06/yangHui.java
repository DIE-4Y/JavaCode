public class yangHui {
	public static void main(String[] args) {
		int n = 10;
		int [][] yangHuiArray = new int[n][];
		for (int i = 0; i < yangHuiArray.length; i++) {
			yangHuiArray[i] = new int [i + 1];
			for (int j = 0; j < i+1; j++) {
				if (j == 0 || j == yangHuiArray[i].length - 1) {
					yangHuiArray[i][j] = 1;
				}else {
					yangHuiArray[i][j] = yangHuiArray[i-1][j] + yangHuiArray[i-1][j-1];
				}
			}
		}
		for (int i = 0; i < yangHuiArray.length; i++) {
			for (int j = 0; j < yangHuiArray[i].length; j++) {
				System.out.print(yangHuiArray[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
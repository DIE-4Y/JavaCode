public class EightQueen {
	public static void main (String[] args) {
		int[][] map = new int [8][8];

		// ��ӡ����λ�� 1
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}

// class Chess {
// 	// map[i][j]��ʾλ��
// 	public boolean put(int[][] map, int i, int j) {
// 		if (map[i][j] == 0) {
// 			for (int t = 0; t < map.length; t++){
// 				for (int m = 0; m < map.length; m++) {
// 					if (map[t][m] == 1) {
// 						if (t == i || m == j || (Math.abs(t-m) == Math.abs(i-j))){
// 							return false;
// 						}
// 					}
// 				}
// 			}
// 			map[i][j] = 1;
// 		}
// 	}
// }
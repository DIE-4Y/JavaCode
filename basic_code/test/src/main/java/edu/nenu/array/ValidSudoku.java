package edu.nenu.array;

public class ValidSudoku {
	public static void main(String[] args) {

	}

	/**
	 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 数字1-9在每一行只能出现一次。
	 * 数字1-9在每一列只能出现一次。 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
	 */
	public static boolean isValidSudoku(char[][] board) {
		int[][] rows = new int[board.length][board.length];
		int[][] columns = new int[board.length][board.length];
		int[][] cells = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int num = board[i][j] - '0' - 1; // 由于数组从0开始，只能到8，所以要减1
				if (rows[i][num] != 0 || columns[i][num] != 0 || cells[i / 3 * 3 + j / 3][num] != 0) {
					return false;
				}
				rows[i][num] = 1;
				columns[j][num] = 1;
				cells[i / 3 * 3 + j / 3][num] = 1;
			}
		}
		return true;
	}
}

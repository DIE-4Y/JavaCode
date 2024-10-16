public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {26, 29, 38, 47, 9, 40, 11};
		int len = array.length;
		for (int i = 1; i < len; i++) {
			boolean flag = false;
			for (int j = 0; j < len - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
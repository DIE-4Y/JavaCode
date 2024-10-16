public class HomeWork05 {
	public static void main(String[] args) {
		int n = 10;
		int[] array = new int[n];
		int sum = 0, max = 0, min = 101, maxIndex = 0, minIndex = 0;
		double ave = 0.0;
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100 + 1);
			sum += array[i];
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
			if (array[i] == 8) {
				flag = true;
			}
		}
		for (int i = array.length -1; i >= 0; i--) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		ave = sum * 1.0 / n;
		System.out.println("ave=" + ave);
		System.out.println("max=" + max);
		System.out.println("maxIndex=" + maxIndex);
		System.out.println("min=" + min);
		System.out.println("minIndex=" + minIndex);
		System.out.println("There's 8 is " + flag);
	}
}
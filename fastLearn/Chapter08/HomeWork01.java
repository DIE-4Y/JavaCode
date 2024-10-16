public class HomeWork01 {
	public static void main (String[] args) {
		double[] nums = {3.2, 3.39, 93.3, 85.4, 39.3, 29.2, 99};
		A01 a1 = new A01();
		double max = a1.max(nums);
		System.out.println("max = " + max);
	}
}

class A01 {
	public double max(double... nums) {
		double max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		return max;
	}
}
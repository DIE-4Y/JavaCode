package edu.nenu.array;

public class moveZeroesInArray {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾 同时保持非零元素的相对顺序。 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
	 */
	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		for (; j < nums.length; ++j) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				++i;
			}
		}
	}
}

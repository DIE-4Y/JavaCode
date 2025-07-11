package edu.nenu;

public class RemoveDuplicatesInArray {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(nums));
	}

	/**
	 * 给你一个 非严格递增排列 的数组 nums 请你 原地 删除重复出现的元素，使每个元素 只出现一次 返回删除后数组的新长度
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		// 如果左指针和右指针指向的值一样，说明有重复的，
		// 这个时候，左指针不动，右指针继续往右移。如果他俩
		// 指向的值不一样就把右指针指向的值往前挪
		for (int r = 1; r < nums.length; ++r) {
			if (nums[l] != nums[r]) {
				nums[++l] = nums[r];
			}
		}
		return ++l;
		// int length = nums.length;
		// for (int i = 0; i < length - 1;) {
		// if (nums[i] == nums[i + 1]) {
		// for (int j = i + 1; j < length - 1; ++j) {
		// nums[j] = nums[j + 1];
		// }
		// --length;
		// continue;
		// }
		// ++i;
		// }
		// return length;
	}
}

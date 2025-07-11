package edu.nenu;

import java.util.HashSet;

public class ContainsDuplicateInArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		containsDuplicate(nums);
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}

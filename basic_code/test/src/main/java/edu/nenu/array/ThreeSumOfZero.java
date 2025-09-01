package edu.nenu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-01
 * @Description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i !=
 *               j、i != k 且 j != k 同时还满足 nums[i] + nums[j] + nums[k] == 0
 *               。请你返回所有和为 0 且不重复的三元组。
 */

public class ThreeSumOfZero {
	public static void main(String[] args) {
		// int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { 0, 0, 0 };
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			numMap.put(nums[i], i);
		}
		// 排序，防止后边出现重复
		Arrays.sort(nums);
		for (int first = 0; first < nums.length; ++first) {
			if (first == 0 || nums[first] != nums[first - 1]) {
				for (int second = first + 1; second < nums.length; ++second) {
					// 第二层进行操作时不能和上一次的数相同除非它刚好是第一层的下一个（防止重复）
					if (second == first + 1 || nums[second] != nums[second - 1]) {
						for (int third = second + 1; third < nums.length; ++third) {
							// 和第二层原因相同
							if (third == second + 1 || nums[third] != nums[third - 1]) {
								if (nums[first] + nums[second] + nums[third] == 0) {
									List<Integer> list = new ArrayList<>();
									list.add(nums[first]);
									list.add(nums[second]);
									list.add(nums[third]);
									res.add(list);
								}
							}
						}
					}
				}
			}
		}
		return res;
	}
}

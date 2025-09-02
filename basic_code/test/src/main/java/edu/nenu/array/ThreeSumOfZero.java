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
			// 防止重复，将可能重复的情况跳过
			if (first != 0 && nums[first] == nums[first - 1]) {
				continue;
			}
			int third = nums.length - 1;
			int target = -nums[first];
			for (int second = first + 1; second < nums.length; ++second) {
				// 防止重复，将可能重复的情况跳过
				if (second != first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}
				// 第三重需要减少运行次数，可采用倒序，和第二层形成双指针，将时间复杂度降为O(n^2)
				while (third > second && nums[third] + nums[second] > target) {
					--third;
				}
				// 如果指针重合，说明没有解
				if (third == second) {
					break;
				}
				// 判断是解是否满足条件
				if (nums[second] + nums[third] == target) {
					List<Integer> list = Arrays.asList(nums[first], nums[second], nums[third]);
					res.add(list);
				}
			}
		}
		return res;
	}
}

package edu.nenu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-03
 * @Description: 给你一个整数数组 nums 和一个整数 k 请你统计并返回 该数组中和为 k 的子数组的个数 。
 *               子数组是数组中元素的连续非空序列。
 */

public class SubArraySumEqualsK {
	public static void main(String[] args) {

	}

	/**
	 * 法1：遍历位置倒序暴力求解
	 * 
	 * @param nums
	 *            数组
	 * @param k
	 *            目标和
	 * @author chenshanquan
	 * @date 2025/9/3 11:37
	 * @return int
	 **/
	// public static int subarraySum(int[] nums, int k) {
	// int count = 0;
	// // 指针一直向右走
	// for (int i = 0; i < nums.length; ++i) {
	// int sum = 0;
	// // 从指针所在位置向前求和
	// for (int end = i; end >= 0; --end) {
	// sum += nums[end];
	// if (sum == k) {
	// ++count;
	// }
	// }
	// }
	// return count;
	// }

	/**
	 * 法2：前缀和求解
	 * 
	 * @param nums
	 *            数组
	 * @param k
	 *            目标和
	 * @author chenshanquan
	 * @date 2025/9/3 11:37
	 * @return int
	 **/
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		// map存放前缀和及其出现次数
		Map<Integer, Integer> map = new HashMap<>();
		// 初始化map，解决第一个就是目标值的情况
		map.put(0, 1);
		int pre = 0;
		for (int i = 0; i < nums.length; ++i) {
			// 计算前缀和并加入map
			pre += nums[i];
			if (map.containsKey(pre - k)) {
				// map对应的前n项和为pre-k的可能有多个
				count += map.get(pre - k);
			}
			map.put(pre, map.getOrDefault(pre, 0) + 1);
		}
		return count;
	}
}

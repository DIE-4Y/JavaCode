package edu.nenu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-03
 * @Description: 滑动窗口最大值
 */

public class MaxNumSlideWindow {
	public static void main(String[] args) {
		int[] num = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		maxSlidingWindow(num, k);
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		int preMax = nums[0];
		int index = 0;
		for (int i = 0; i < nums.length - k + 1; ++i) {
			int max = nums[i];
			if (preMax != nums[i]) {
				max = preMax > nums[i + k - 1] ? preMax : nums[i + k - 1];
				preMax = max;
				list.add(max);
			} else {
				for (int start = i + 1; start < i + k; ++start) {
					max = max > nums[start] ? max : nums[start];
				}
				list.add(max);
				preMax = max;
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

}

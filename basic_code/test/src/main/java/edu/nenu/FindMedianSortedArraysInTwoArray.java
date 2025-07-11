package edu.nenu;

public class FindMedianSortedArraysInTwoArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 5 };
		int[] nums2 = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	/**
	 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2 请你找出并返回这两个正序数组的 中位数 。 算法的时间复杂度应该为
	 * O(log (m+n)) 。
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] num = new int[nums1.length + nums2.length];
		for (int i = 0, n1 = 0, n2 = 0; i < num.length; ++i) {
			if (n1 < nums1.length && n2 < nums2.length) {
				if (nums1[n1] <= nums2[n2]) {
					num[i] = nums1[n1++];
					continue;
				}
				num[i] = nums2[n2++];
			} else if (n1 == nums1.length) {
				// nums1已经遍历完 nums2后边的直接复制
				num[i] = nums2[n2++];
			} else {
				num[i] = nums1[n1++];
			}
		}
		if (num.length % 2 == 0) {
			return (num[num.length / 2] + num[num.length / 2 - 1]) / 2.0;
		}
		return num[num.length / 2];
	}
}

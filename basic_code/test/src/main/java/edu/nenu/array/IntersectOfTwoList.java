package edu.nenu.array;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectOfTwoList {
	public static void main(String[] args) {

	}

	/**
	 * 输入两个数组，返回两个数组的交集
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> arrays = new ArrayList<>();
		int p1 = 0, p2 = 0;
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] == nums2[p2]) {
				arrays.add(nums1[p1]);
				++p1;
				++p2;
			} else if (nums1[p1] < nums2[p2]) {
				++p1;
			} else {
				++p2;
			}
		}
		int[] res = new int[arrays.size()];
		for (int i = 0; i < arrays.size(); i++) {
			res[i] = arrays.get(i);
		}
		return res;
	}

}

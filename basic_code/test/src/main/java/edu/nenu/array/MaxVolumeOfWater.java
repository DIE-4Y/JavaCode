package edu.nenu.array;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-08-18
 * @Description: 给定一个长度为 n 的整数数组 height 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i,
 *               height[i]) 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水 返回容器可以储存的最大水量。
 */
public class MaxVolumeOfWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int vol = 0;
		while (left < right) {
			int h = Math.min(height[left], height[right]);
			vol = Math.max((right - left) * h, vol);
			// 移动短板,直到短边比现在的最短的高才有可能增加容量
			while (height[left] <= h && left < right) {
				++left;
			}
			while (height[right] <= h && left < right) {
				--right;
			}
		}
		return vol;
	}
}

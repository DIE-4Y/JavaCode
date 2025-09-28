package edu.nenu.array;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-04
 * @Description: 最大子数组和
 */

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(nums);
    }

    /**
     * 动态规划，动态转移方程：f(i)=max{f(i−1)+nums[i],nums[i]}
     * @param nums 数组
     * @return int
     * @author chenshanquan
     * @date 2025/9/4 11:23
     **/
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int preMax = 0;
        for (int num : nums) {
            preMax = Math.max(preMax + num, num);
            max = Math.max(preMax, max);
        }
        return max;
    }
}

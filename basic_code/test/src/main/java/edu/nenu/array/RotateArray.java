package edu.nenu.array;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    /**
     * 三步颠倒法旋转数组
     * @param nums 数组
     * @param k 位移步长
     * @return void
     * @author chenshanquan
     * @date 2025/9/4 14:41
     **/
    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组的指定下标间的元素
     * @param nums 数组
     * @param start 开始下标
     * @param end 结束下标
     * @return void
     * @author chenshanquan
     * @date 2025/9/28
     **/
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}

package cn.bravedawn.zd_31;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/29 20:41
 *
 * 31.下一个排列
 */
public class Solution {


    /**
     * 算法的核心思想：将右边最大的数和前面最小的数进行交互就能够得到下一个排列
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        int[] arr2 = {3, 2, 1};
        nextPermutation(arr2);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;

        // 从后往前找，第一个比后一个元素小的元素的下标
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 从后往前找，找到第一个比num[i]大的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // 交换这两个数的位置
            swap(nums, i, j);
        }

        // 这个主要是用来解决边界问题，也就是最后一个序列翻转为第一个序列
        reverse(nums, i + 1);

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // 翻转从start开始的数组序列，原来肯定是降序（从大到小），转换为升序（从小到大）
    public static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}

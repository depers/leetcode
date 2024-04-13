package cn.bravedawn.zd.zd_189;

import java.util.Arrays;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 15:17
 * <p>
 * 189.轮转数组
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }


    public static void rotate(int[] nums, int k) {
        int len = nums.length;

        for (int i = 0; i < k; i++) {

            for (int j = len - 1; j >= 1; j--) {
                swap(nums, j - 1, j);
            }
        }
    }

    public static void swap(int nums[], int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}

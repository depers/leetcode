package cn.bravedawn.jd_83;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/8 09:35
 *
 * 283. 移动零
 */
public class Solution {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 1;


        // [0,1,0,3,12]
        while (left < right && right < len) {
            while (right < len && nums[left] != 0) {
                left++;
                right++;
            }

            while (right < len && nums[right] == 0) {
                right++;
            }

            if (right < len) {
                swap(nums, left, right);
                left++;
                right++;
            }

        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

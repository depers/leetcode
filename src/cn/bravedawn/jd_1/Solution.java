package cn.bravedawn.jd_1;

import java.util.Arrays;

/**
 * @Author : fengx9
 * @Project : leetcode
 * @Date : Created in 2024-01-24 14:38
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));


        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
    }


    public static int[] twoSum(int[] nums, int target) {
        int firstIndex = 0, secondIndex = 0;
        int firstNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (firstNum + nums[i] == target) {
                secondIndex = i;
                break;
            } else {
                firstNum = nums[i];
                firstIndex = i;
            }
        }

        return new int[]{firstIndex, secondIndex};
    }

}

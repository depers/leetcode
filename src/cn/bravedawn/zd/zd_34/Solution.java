package cn.bravedawn.zd.zd_34;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/6 17:13
 *
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    private static int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果当前中间位置的值等于目标值，依然往左侧找，找目标值的最小索引位置
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }


    private static int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] <= target) {
                // 如果当前中间位置的值等于目标值，则仍往右走，找到目标值的最大索引位置
                left = mid + 1;
            }
        }
        return right;
    }

    private static int[] searchRange(int[] nums, int target) {
        int lowerResult = lowerBound(nums, target);
        int upperResult = upperBound(nums, target);
        // 不存在情况
        if (upperResult < lowerResult) {
            return new int[]{-1, -1};
        }
        return new int[]{lowerResult, upperResult};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}

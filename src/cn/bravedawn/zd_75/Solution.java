package cn.bravedawn.zd_75;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/7 23:21
 */
public class Solution {


    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, left, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, right);
        }

    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }

        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        quickSort(nums, left, right);
        System.out.println(Arrays.toString(nums));
    }
}

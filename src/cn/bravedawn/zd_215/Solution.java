package cn.bravedawn.zd_215;

import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/7 16:55
 *
 * 215.数组中的第K个最大元素
 */
public class Solution {


    public static int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[target];
            }
            else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

    }


    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right){

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
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

}

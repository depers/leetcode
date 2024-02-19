package cn.bravedawn.base.searching;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/5 11:14
 */
public class BinarySearch {


    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }


    public static int recursionBinarySearch(int[] nums, int target, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                return recursionBinarySearch(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                return recursionBinarySearch(nums, target, mid + 1, right);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 19, 66, 77, 99};
        int target = 99;

        int result = binarySearch(nums, target, 0, nums.length);
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("target=" + target);
        System.out.println("result=" + result);

    }


}

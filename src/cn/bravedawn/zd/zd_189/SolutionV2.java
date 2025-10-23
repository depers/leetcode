package cn.bravedawn.zd.zd_189;

import java.util.Arrays;

/**
 * @Author : depers
 * @Date : Created in 2025-10-23 17:33
 */
public class SolutionV2 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 4;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }


    public static void rotate(int[] nums, int k) {
        int len = nums.length;

        /**
         * 这里有两种情况：
         * 1. 当 0 < k < n时
         * 2. 当 k = n时，等于没翻转
         * 3. 当 k > n时，翻转次数和 0 < k < n是一样的
         *
         * 所以这里做一个取余操作
         */
        k = k % len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }


    private static void reverse(int num[], int i, int j) {
        while (i < j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
}

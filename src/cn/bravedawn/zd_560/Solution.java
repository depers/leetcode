package cn.bravedawn.zd_560;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 11:03
 *
 * 560.和为 K 的子数组
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }


    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int result = 0;

        int num = 0;
        for (int i = 0; i < len; i++) {
            num = num + nums[i];
            if (num > k) {
                i = i - 1;
                num = 0;
            }

            if (i == len - 1 && len > 1) {
                result++;
                return result;
            }

            if (num == k) {
                i = i - 1;
                result++;
                num = 0;
            }


        }

        return result;
    }
}

package cn.bravedawn.zd.zd_53;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 12:59
 * <p>
 * 53. 最大子数组和
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];

        if (len == 1) {
            return nums[0];
        }

        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            dp[i] = nums[i];

            for (int j = i + 1; j < len; j++) {
                sum += nums[j];

                if (dp[i] < sum) {
                    dp[i] = sum;
                }
            }


            max = Math.max(max, dp[i]);
        }


        return max;
    }



}

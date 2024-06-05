package cn.bravedawn.zd.zd_198;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/5 18:24
 *
 * 198.打家劫舍
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));

        /**
         * k = 0, dp[0] = 0
         * k = 1, dp[1] = 2
         * k = 2, dp[k] = max(dp[k-2] + nums[k-1], dp[k-1])
         */
    }

    public static int rob(int[] nums) {

        // dp数组的含义，代表在偷第k间房子的时候的最大金额
        int n = nums.length;
        int[] dp = new int[n+1];
        // 动态方程，dp[k] = max(dp[k-1], num[k-1] + dp[k-2])

        // 初始化
        dp[0] = 0;
        dp[1] = nums[0];

        // 循环遍历
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }

        return dp[n];
    }
}

package cn.bravedawn.zd.zd_494;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/8 13:07
 * 494.目标和
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        /**
         * 这里有几个比较关键的点
         * 1. nums的元素是不能重复使用的
         * 2. 可以在每个整数前面添加加号或是减号
         * 3. 拼接起来的表达式计算可得到target
         */

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) {
            return 0; // 没有方案
        }

        if ((target + sum) % 2 == 1) {
            return 0; // 没有方案
        }

        int bagSize = (target + sum) / 2;

        // dp[j]的含义，当背包的数量为j时，有多少种装物品的方法
        int[] dp = new int[bagSize+1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) { // 遍历物品
            for (int j = bagSize; j >= nums[i]; j--) { // 遍历背包
                // 背包问题，统一的递推公式
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagSize];

    }

}

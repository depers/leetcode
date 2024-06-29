package cn.bravedawn.zd.zd_518;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/28 22:09
 *
 * 518. 零钱兑换 II
 */
public class Solution {

    public int change(int amount, int[] coins) {

        // dp代表凑成金额i的硬币组合数量，也就是说装满背包j需要dp[j]种方法
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

}

package cn.bravedawn.zd.zd_322;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/27 19:27
 *
 * 322.零钱兑换
 * 可以参考题目零钱兑换2和组合总和4
 */
public class Solution {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        // 代表当前金额所需的钱币数量
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                if (dp[j - coins[i]] != Integer.MAX_VALUE) { // 如果dp[j - coins[i]]是初始值则跳过
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}

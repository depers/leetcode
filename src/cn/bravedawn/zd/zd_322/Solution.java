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
        // 代表当前金额所需的最少钱币数量，j代表的金额
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        // dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // i是物品的下标，也就是取那一个金额的硬币
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            // j是金额，也就是这个金额下，需要的硬币的个数有几个
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                if (dp[j - coins[i]] != Integer.MAX_VALUE) { // 如果dp[j - coins[i]]是初始值则跳过
                    // dp[j - coins[i]]金额减去当前硬币金额后的数量，dp[j]则是之前计算所得的硬币的数量
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

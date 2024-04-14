package cn.bravedawn.zd.zd_96;

import java.util.ArrayDeque;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/14 21:32
 *
 * 96.不同的二叉搜索树
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        // 初始化
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];

    }

}

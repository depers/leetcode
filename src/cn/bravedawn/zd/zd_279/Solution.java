package cn.bravedawn.zd.zd_279;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/10/8 21:17
 *
 * 247.完全平方数
 */
public class Solution {

    /**
     * 走一遍流程：
     *
     * i = 1时，dp[1] = 1, n = 1
     * i = 2时，dp[2] = 2, n = 1 + 1
     * i = 3时，dp[3] = 3, n = 1 + 1 + 1
     * i = 4时，dp[4] = 1, n = 4
     * i = 5时，dp[5] = 2, n = 4 + 1
     */


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(5));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}

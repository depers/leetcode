package cn.bravedawn.zd.zd_221;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/30 08:32
 *
 * @apiNote 221.最大正方形
 * @see <a href="https://blog.csdn.net/K346K346/article/details/125678407">最大正方形（LeetCode 221）</a>
 */
public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j]为正方形右下角的值为1的正方形的最大边长
        // 对dp数组进行初始化
        int maxSide = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                // 处理边界条件
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),  dp[i-1][j-1]) + 1;
                }
                if (dp[i][j] > maxSide) {
                    maxSide = dp[i][j];
                }
            }
        }

        return maxSide * maxSide;
    }
}

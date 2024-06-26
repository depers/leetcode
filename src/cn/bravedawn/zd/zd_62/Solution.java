package cn.bravedawn.zd.zd_62;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/2 22:14
 *
 * 62.不同路径
 */
public class Solution {

    /**
     * m行，n列的矩阵
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(uniquePaths(m, n));
    }
}

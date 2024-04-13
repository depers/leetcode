package cn.bravedawn.zd.zd_72;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/12 08:49
 *
 * 72.编辑距离
 */
public class Solution {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int result = minDistance(word1, word2);
        System.out.println(result);
    }

    public static int minDistance(String word1, String word2) {
        int rows = word1.length();
        int cols = word2.length();
        int[][] dp = new int[rows+1][cols+1];


        for (int i = 0; i <= rows; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= cols; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                // 两个字符相同
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 两个字符不相同
                    // 替换：dp[i-1][j-1]+1，假如word1=ab，word2=ac，将word1的b替换成c，其实就是dp[i-1][j-1]+1
                    // 删除：dp[i-1][j]+1 删除word1的字符，假如word1=ab，word2=a，删除word1的b，其实就是dp[i-1][j]+1
                    // 添加：dp[i][j-1]+1 删除word2的字符，假如word1=a，word2=ab，word1添加一个b，其实就是dp[i][j-1]+1
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }

        return dp[rows][cols];
    }
}

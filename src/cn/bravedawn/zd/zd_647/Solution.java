package cn.bravedawn.zd.zd_647;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/25 11:11
 *
 * 647.回文子串，参考代码随想录
 */
public class Solution {

    public static void main(String[] args) {
        countSubstrings("aba");
    }

    public static int countSubstrings(String s) {

        // Java默认就是false
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        int len = s.length();

        // 这个顺序很重要，这里的i指的是行，j指的是列
        // 因为dp[i+1][j-1]在dp[i][j]的有下方，所以在遍历的时候，我们的顺序是i从下往上，j从左往右
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;
    }


}

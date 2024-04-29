package cn.bravedawn.zd.zd_139;

import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/29 21:32
 *
 * 139.单词拆分
 */
public class Solution2 {

    /**
     * 动态规划
     */

    public boolean wordBreak(String s, List<String> wordDict) {

        // 长度为 n+1n+1n+1。nnn 为字符串长度。dp[i]dp[i]dp[i] 表示 sss 的前 iii 位是否可以用 wordDictwordDictwordDict 中的单词表示。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 状态转换方程，前一个位置满足且当前位置也满足
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // 看dp的最后一个位置是不是ture，如果是的话就是满足条件的
        return dp[s.length()];
    }
}

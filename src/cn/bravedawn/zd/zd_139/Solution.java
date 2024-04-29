package cn.bravedawn.zd.zd_139;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/29 20:46
 *
 * 139.单词拆分
 */
public class Solution {

    /**
     * 回溯法
     */

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, new ArrayDeque<>(), wordDict);
    }

    public static boolean dfs(String s, Deque<String> deque, List<String> wordDict) {
        String currentStr = String.join("", deque);
        if (currentStr.equals(s)) {
            return true;
        }
        if (currentStr.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            deque.addLast(wordDict.get(i));
            boolean result = dfs(s, deque, wordDict);
            deque.removeLast();

            if (result) {
                return true;
            }
        }

        return false;
    }

}

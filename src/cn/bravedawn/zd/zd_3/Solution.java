package cn.bravedawn.zd.zd_3;

import java.util.HashMap;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/1 19:38
 *
 * 3.无重复字符的最长子串
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 记录最近一次出现这个字符的位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // 用目前的最大值和当前值到最左边的位置的距离
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

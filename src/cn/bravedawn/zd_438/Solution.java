package cn.bravedawn.zd_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 09:03
 *
 * 438.找到字符串中所有字母异位词
 */
public class Solution {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));

        String s2 = "abab";
        String p2 = "ab";
        System.out.println(findAnagrams(s2, p2));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = s.length();
        int step = p.length();

        for (int i = 0; i < len; i++) {

            if (i + step - 1 < len) {
                String subStr = s.substring(i, i + step);
                if (isValid(subStr, p)) {
                    result.add(i);
                }
            }
        }

        return result;
    }


    public static boolean isValid(String sub, String p) {
        char[] subArray = sub.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(subArray);
        Arrays.sort(pArray);
        return new String(subArray).equals(new String(pArray));
    }

}

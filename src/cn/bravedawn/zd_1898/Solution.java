package cn.bravedawn.zd_1898;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/20 11:28
 *
 * 1898. 可移除字符的最大数目
 */
public class Solution {


    public static int maximumRemovals(String s, String p, int[] removable) {
        int len = removable.length;
        int left = 0;
        int right = len;

        while (left < right) {
            String str = s;
            int mid = left + (right - left) / 2;
            str = delChatAt(str, removable, mid);

            if (isSubsequence(p, str)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static String delChatAt(String str, int[] indexs, int num) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <= num; i++) {
            chars[indexs[i]] = ' ';
        }

        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                builder.append(c);
            }
        }


        return builder.toString();
    }

    /**
     * 判断子序列
     * @param s 子序列字符串
     * @param t 字符串
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }



    public static void main(String[] args) {
        System.out.println(maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", new int[]{12,5}));
    }

}

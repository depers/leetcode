package cn.bravedawn.zd.zd_5;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/4 10:27
 *
 * 5.最长回文子串
 */
public class Solution {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }


    private static boolean validPalindrome(char[] charArray, int left, int right) {

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }
}


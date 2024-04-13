package cn.bravedawn.jd.jd_14;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/4 16:13
 *
 * 14. 最长公共前缀
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder builder = new StringBuilder();
        int num = 0;
        int arraySize = strs.length;

        for (int i = 0; i < strs[0].length(); i++) {

            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == c) {
                    num++;
                } else {
                    break;
                }
            }

            if (num == arraySize-1) {
                builder.append(c);
            } else {
                break;
            }
            num = 0;
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"cir","car"};
        System.out.println(longestCommonPrefix(arr));
    }
}

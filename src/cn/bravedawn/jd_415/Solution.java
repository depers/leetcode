package cn.bravedawn.jd_415;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/27 10:00
 *
 * 415. 字符串相加
 */
public class Solution {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder builder = new StringBuilder();

        for (int c = 0; i >= 0 || j >= 0 || c > 0; i--, j--) {

            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int result = a + b + c;
            builder.append(result % 10);
            c = result / 10;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123")
        );;
    }
}

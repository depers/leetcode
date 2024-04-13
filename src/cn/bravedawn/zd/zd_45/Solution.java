package cn.bravedawn.zd.zd_45;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/29 11:12
 *
 * 43. 字符串相乘
 */
public class Solution {

    /**
     * 两个数相乘后的商，长度最短是m+n-1，最长是m+n
     */

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(), n = num2.length();

        // 这两个数的乘积的最大长度为m+n，申请一个这个长度的数组
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            // 从低位开始取数
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                // 从低位开始取数
                int b = num2.charAt(j) - '0';

                // 将每次计算的值进行保存
                arr[i + j + 1] += a * b;
            }
        }

        // 进行进位运算
        for (int i = arr.length - 1; i > 0; --i) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        // 因为商的长度最短是m+n-1，如果数组最高位为0则从等二个位置开始拼接字符串
        int i = arr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        for (; i < arr.length; ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        multiply(num1, num2);
    }
}

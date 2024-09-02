package cn.bravedawn.zd.zd_394;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/2 21:55
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        // 在这种情况下就会报错
        System.out.println(solution.decodeString("3[a2[c]]"));

    }

    public String decodeString(String s) {

        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int digit = 0;
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                digit = Integer.parseInt(String.valueOf(array[i]));
            } else if (array[i] == '[') {
                str = "";
            } else if (array[i] == ']') {
                for (int j = 0; j < digit; j++) {
                    sb.append(str);
                }
                digit = 0;
            }  else if (digit != 0) {
                str += array[i];
            } else {
                sb.append(array[i]);
            }
        }

        return sb.toString();
    }

}

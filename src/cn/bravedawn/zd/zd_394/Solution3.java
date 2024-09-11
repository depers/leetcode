package cn.bravedawn.zd.zd_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/2 22:27
 *
 * 394.字符串解码（正确版）
 */
public class Solution3 {


    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 存储数字的栈
        Deque<Integer> stackMulti = new ArrayDeque<>();

        // 存储[]中间字母的栈
        Deque<String> stackRes = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 数字和字符串同时入栈
                stackMulti.addLast(multi);
                stackRes.addLast(res.toString());

                // 清空数字和字符串
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 对当前字符串和数字进行倍数运算
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.removeLast();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                // 补充之前计算的字符串
                res = new StringBuilder(stackRes.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}

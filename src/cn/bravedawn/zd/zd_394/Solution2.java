package cn.bravedawn.zd.zd_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/2 22:06
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        // 在这种情况下就会报错
        System.out.println(solution.decodeString("3[a2[c]]"));
    }


    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Integer> indexStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                indexStack.push(Integer.parseInt(c + ""));
            } else if (c == '[') {
                stack.push(c);
            } else if (c == ']') {
                StringBuilder res = new StringBuilder();
                int time = indexStack.pop();
                while (!stack.isEmpty()) {
                    if (stack.peek() != '[') {
                        res.append(stack.pop());
                    } else {
                        stack.pop();
                    }
                }

                for (int j = 0; j < time; j++) {
                    sb.append(res);
                }
            } else if (indexStack.isEmpty()){
                sb.append(c);
            } else {
                stack.push(c);
            }
        }

        return sb.toString();
    }
}

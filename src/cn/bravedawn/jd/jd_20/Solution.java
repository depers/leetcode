package cn.bravedawn.jd.jd_20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/8 10:50
 *
 * 20.有效的括号
 */
public class Solution {

    public static boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Deque<Character> deque = new LinkedList<>();
        boolean flag = false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '{' || c == '(' || c == '[') {
                deque.push(c);
            }else if (map.get(deque.peek()) != null &&  map.get(deque.peek()) == c) {
                deque.pop();
            } else {
                return false;
            }
        }

        if (deque.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}

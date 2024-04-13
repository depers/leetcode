package cn.bravedawn.jd.jd_9;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/1/31 11:01
 *
 * 9.回文数
 * 耗时：17分钟14秒
 */
public class Solution {

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);
        char[] chars = str.toCharArray();


        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }

        if (str.contentEquals(builder)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}

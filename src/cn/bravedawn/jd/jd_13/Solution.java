package cn.bravedawn.jd.jd_13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/1 10:50
 *
 * 13. 罗马数字转整数
 * 耗时：39分33秒
 */
public class Solution {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }



    public static int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length;) {
            char c = chars[i];
            if (c == 'I' || c == 'X' || c == 'C') {
                if (i + 1 < chars.length && map.get(String.valueOf(c) + String.valueOf(chars[i+1])) != null) {
                    result += map.get(String.valueOf(String.valueOf(c) + String.valueOf(chars[i+1])));
                    i = i + 2;
                    continue;
                }
            }

            result += map.get(String.valueOf(c));
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        // M + CM + XC + IV
        System.out.println(romanToInt("MCMXCIV"));
    }
}

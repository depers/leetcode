package cn.bravedawn.zd_49;

import java.util.*;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-26 09:34
 *
 * 49.字母异位词分组
 */
public class Solution {


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            // 排序后每个字母异位词，的字符串都是一样的了
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}

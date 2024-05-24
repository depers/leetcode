package cn.bravedawn.zd.zd_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/23 22:21
 *
 * 438.找到字符串中所有字母异位词
 */
public class Solution2 {

    /**
     * 滑动窗口版本
     */

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        int[] chars = new int[26];
        // 下标预埋为1
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }

        int left = 0, right = 0;
        char[] sc = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        while (right < sLen){
            // 说明p中也包含该字符
            if (chars[sc[right] - 'a'] > 0) {
                chars[sc[right] - 'a']--;
                right++;
                if (right - left == pLen){
                    ans.add(left);
                }
            } else {
                // p中不包含该字符或者说该元素
                chars[sc[left] - 'a']++;
                left++;
            }
        }
        return ans;
    }

}

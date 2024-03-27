package cn.bravedawn.zd_128;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-27 09:08
 *
 * 128. 最长连续序列
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2));
    }


    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int bigLen = 0;

        for (int num : nums) {
            numSet.add(num);
        }


        for (int num : numSet) {
            int currentNum = 0;
            int currentLen = 0;

            if (!numSet.contains(num - 1)) {
                currentNum = num;
                currentLen = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentLen++;
                }
            }

            bigLen = Math.max(currentLen, bigLen);
        }

        return bigLen;
    }
}

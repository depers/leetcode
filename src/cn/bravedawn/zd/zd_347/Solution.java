package cn.bravedawn.zd.zd_347;

import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/11 22:02
 * <p>
 * 错误尝试第一版，题目意思没理解
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= k) {
                list.add(entry.getKey());
            }
        }

        System.out.println(map.toString());

        return list.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
    }

}

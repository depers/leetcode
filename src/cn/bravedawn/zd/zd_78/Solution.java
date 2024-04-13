package cn.bravedawn.zd.zd_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/12 13:20
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(nums, len, new ArrayDeque<>(), result, 0);
        return result;
    }


    public static void dfs(int[] nums, int len, Deque<Integer> deque, List<List<Integer>> result, int index) {
        boolean isExist = isExist(deque, result);
        if (!isExist) {
            result.add(new ArrayList<>(deque));
        }

        if (deque.size() == len) {
            return;
        }

        for (int i = index; i < len; i++) {
            deque.addLast(nums[i]);
            dfs(nums, len, deque, result, i+1);
            deque.removeLast();
        }
    }

    private static boolean isExist(Deque<Integer> deque, List<List<Integer>> result) {
        for (List<Integer> item : result) {
            return item.equals(new ArrayList<>(deque));
        }
        return false;
    }
}

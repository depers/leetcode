package cn.bravedawn.zd.zd_39;

import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/31 09:25
 *
 * 33.组合总和
 */
public class Solution {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int len = candidates.length;
        dfs(candidates, target, 0, len, res, deque);

        return res;
    }


    /**
     *
     * @param candidates 原数组
     * @param target 目标值
     * @param begin 开始下标，这个参数很重要，这样每次都会从当前这个下标开始选数，下标之前的数字就不选了
     * @param len 长度
     * @param res 最后的结果
     * @param deque 栈
     */
    private static void dfs(int[] candidates, int target, int begin, int len, List<List<Integer>> res, Deque<Integer> deque) {

        int sum = isSum(deque);
        if (sum == target) {
            res.add(new ArrayList<>(deque));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = begin; i < len; i++) {
            deque.addLast(candidates[i]);
            dfs(candidates, target, i, len, res, deque);
            deque.removeLast();
        }
    }

    public static int isSum(Deque<Integer> deque) {
        int sum = 0;
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}

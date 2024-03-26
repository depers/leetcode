package cn.bravedawn.zd_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-14 09:52
 *
 * 22. 括号生成
 *
 */
public class Solution {


    /**
     * 生成括号
     * @param n 生成括号的对数
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历
        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * 递归函数
     * @param curStr 生成一种情况的字符串
     * @param left 左子树下探的深度
     * @param right 右子树下探的深度
     * @param n 生成括号的对数，或者说下探的最大深度
     * @param res 存储对数字符串的列表
     */
    private static void dfs(String curStr, int left, int right, int n, List<String> res) {
        // 在递归终止的时候，直接把它添加到结果集
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，如果不满足就剪枝，注意这个细节）
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left+1, right, n, res);
        }

        if (right < n) {
            dfs(curStr + ")", left, right+1, n, res);
        }
    }



    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

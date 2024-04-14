package cn.bravedawn.zd.zd_96;

import java.util.ArrayDeque;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/14 21:32
 *
 * 96.不同的二叉搜索树
 */
public class Solution {

    /**
     * 算法思想
     * 以n为3来展开分析
     * 第一点：
     *      n为0时，只有1种二叉搜索树
     *      n为1时，只有1种二叉搜索树
     *      n为2时，有2种二叉搜索树
     *      n为3时，有5种二叉搜索树
     * 第二点：
     *      当根节点为1时，二叉搜索树的个数：左子树0个节点 * 右子树2个节点，换成公式：dp[0] * dp[2]
     *      当根节点为2时，二叉搜索树的个数：左子树1个节点 * 右子树1个节点，换成公式：dp[1] * dp[1]
     *      当根节点为3时，二叉搜索树的个数：左子树2个节点 * 右子树0个节点，换成公式：dp[2] * dp[0]
     *
     *  dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
     */

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        // 初始化
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];

    }

}

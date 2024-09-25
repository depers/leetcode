package cn.bravedawn.zd.zd_337;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/25 20:55
 *
 * 337.打家劫舍 III
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction(TreeNode root) {
        // dp数组的第0位代表不偷当前节点所能获取的最大值，第1位代表偷该节点所能获取的最大值
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }

        // 偷左侧节点的最大值
        int[] left = robAction(root.left);

        // 偷右侧节点的最大值
        int[] right = robAction(root.right);

        // 不偷当前节点的最大值，获取左右子节点的最大值
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点，获取左右子节点非当前节点的最大值
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }

}

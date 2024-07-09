package cn.bravedawn.zd.zd_437;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/9 21:03
 */
public class Solution2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans, t;
    public int pathSum(TreeNode root, int _t) {
        t = _t;
        dfs1(root);
        return ans;
    }
    void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }
    void dfs2(TreeNode root, long val) {
        if (val == t) ans++;
        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000000000);
        TreeNode l1 = new TreeNode(1000000000);
        root.left = l1;
        TreeNode l2 = new TreeNode(294967296);
        l1.left = l2;
        TreeNode l3 = new TreeNode(1000000000);
        l2.left = l3;
        TreeNode l4 = new TreeNode(1000000000);
        l3.left = l4;
        TreeNode l5 = new TreeNode(1000000000);
        l4.left = l5;

        int targetNum = 0;

        Solution2 solution = new Solution2();
        int result = solution.pathSum(root, targetNum);
        System.out.println(result);

    }

}

package cn.bravedawn.zd.zd_437;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/9 20:01
 *
 * 437.路径总和III
 */
public class Solution {

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


    int path = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以每个节点为起点，统计满足条件的路径数
        sum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return path;
    }

    // 切记这里sum要改成long类型
    private void sum(TreeNode root, long sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            path++;
        }
        sum(root.left, sum);
        sum(root.right, sum);
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

        Solution solution = new Solution();
        int result = solution.pathSum(root, targetNum);
        System.out.println(result);

    }

}

package cn.bravedawn.zd.zd_98;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/16 07:44
 *
 * 98.验证二叉搜索树
 */
public class Solution {


    public static void main(String[] args) {
        // TreeNode left = new TreeNode(1);
        // TreeNode right = new TreeNode(3);
        // TreeNode node = new TreeNode(2, left, right);

        TreeNode t1 = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode t2 = new TreeNode(5, new TreeNode(4), t1);
        System.out.println(isValidBST(t2));
    }

    public static boolean isValidBST(TreeNode root) {
        // 不仅要考虑左节点小于根节点，右节点大于根节点，还要考虑左子树都小于根节点的值，右节点都大于根节点的值
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long lower, long upper) {

        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= upper) {
            return false;
        }

        // 递归左子树
        boolean a = isValidBST(root.left, lower, root.val);
        // 递归右子树
        boolean b = isValidBST(root.right, root.val, upper);

        return a && b;

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

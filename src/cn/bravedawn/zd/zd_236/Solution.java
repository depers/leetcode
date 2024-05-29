package cn.bravedawn.zd.zd_236;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/28 07:48
 * 236. 二叉树的最近公共祖先
 * 参考思路：https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html
 */
public class Solution {



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        node1.left = node3;
        node1.right = node4;
        TreeNode node5 = new TreeNode(8);
        node2.right = node5;

        TreeNode node = lowestCommonAncestor(root, node3, node1);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 如果根节点是p或q，或是null返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 从低到高寻找，采用后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p和q分别位于左右子树
        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null) {
            // p和q都位于左子树
            return left;
        } else if (left == null && right != null) {
            // p和q都位于右子树
            return right;
        } else {
            // 左右子树都没有匹配
            return null;
        }
    }


}

package cn.bravedawn.zd.zd_114;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/28 19:36
 *
 * 114.二叉树展开为链表
 */
public class Solution {

    public static void main(String[] args) {
        // 1,2,5,3,4,null,6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));

        flatten(root);
        preorderTraversal(root);

    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        handle(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public static void handle(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);
        handle(root.left, list);
        handle(root.right, list);
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

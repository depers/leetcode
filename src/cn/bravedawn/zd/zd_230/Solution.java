package cn.bravedawn.zd.zd_230;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/28 20:06
 *
 * 230. 二叉搜索树中第K小的元素
 */
public class Solution {

    private static Deque<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        root.right = r1;


        int result = kthSmallest(root, 2);
        System.out.println(result);

    }


    public static int kthSmallest(TreeNode root, int k) {
        search(root);
        int len = stack.size();

        for (int i = 1; i <= len; i++) {
            if (i == k) {
                return stack.peek();
            }
            stack.pop();
        }
        return 0;
    }

    public static void search(TreeNode root) {
        if (root == null) {
            return;
        }
        search(root.left);
        stack.add(root.value);
        search(root.right);
    }



    public static class TreeNode{

        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

}

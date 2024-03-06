package cn.bravedawn.jd_94;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/5 09:50
 */
public class TreeNode {

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

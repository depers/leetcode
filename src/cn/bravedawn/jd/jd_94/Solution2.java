package cn.bravedawn.jd.jd_94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/5 09:50
 *
 * 94.中序遍历二叉树的递归版本
 *
 * 中序的意思是说根节点的位置放在哪里
 */
public class Solution2 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));

        System.out.println(inorderTraversal(node));
    }

}

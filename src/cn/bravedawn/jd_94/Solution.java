package cn.bravedawn.jd_94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/5 09:50
 *
 * 94.中序遍历二叉树的非递归版本
 */
public class Solution {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        // 两层循环遍历，两个条件第一个是根结点不为空，第二个是栈内元素不为null
        while (root != null || !stk.isEmpty()) {
            // 将根结点的左侧所有元素放到栈中
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 将栈顶的元素出栈
            root = stk.pop();
            res.add(root.val);
            // 将根结点指向右侧
            root = root.right;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));

        System.out.println(inorderTraversal(node));
    }

}

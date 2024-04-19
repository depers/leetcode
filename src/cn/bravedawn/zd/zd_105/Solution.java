package cn.bravedawn.zd.zd_105;


import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/18 17:29
 *
 * 105.从前序与中序遍历序列构造二叉树
 */
public class Solution {

    /**
     * 前序遍历：[根节点，左子树，右子树]
     * 中序遍历：[左子树，根节点，右子树]
     */

    private static Map<Integer, Integer> initMap;
    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序和中序遍历的长度是一样的
        int len = preorder.length;
        initMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            initMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, len-1, 0, len-1);
    }


    /**
     *
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数据
     * @param preorderLeft
     * @param preorderRight
     * @param inorderLeft
     * @param inorderRight
     * @return
     */
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {

        if (preorderLeft > preorderRight) {
            return null;
        }

        int rootVal = preorder[preorderLeft];
        int rootIndexForInorder = initMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);

        // 根据中序遍历计算左子树的节点个数
        int leftNodeSize = rootIndexForInorder - inorderLeft;

        // 递归构造左子树
        // 最后的四个参数的意思分别是：左子树在前序遍历中的左下标，左子树在前序遍历中的右下标，左子树在中序遍历中的左下标，左子树在中序遍历中的右下标
        node.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftNodeSize, inorderLeft, rootIndexForInorder - 1);

        // 递归构造右子树
        // 最后的四个参数的意思分别是：右子树在前序遍历中的左下标，右子树在前序遍历中的右下标，右子树在中序遍历中的左下标，右子树在中序遍历中的右下标
        node.right = myBuildTree(preorder, inorder, preorderLeft + leftNodeSize + 1, preorderRight, rootIndexForInorder + 1, inorderRight);
        return node;
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


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution solution = new Solution();
        solution.buildTree(preorder, inorder);
    }
}

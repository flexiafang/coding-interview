package 面试题07_重建二叉树;

import util.TreeNode;

/**
 * @Author hustffx
 * @Date 2020/8/9
 */
public class ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[s1]);
        int index = findIndex(inorder, s2, e2, preorder[s1]);

        root.left = buildTree(preorder, s1 + 1, s1 - s2 + index, inorder, s2, index - 1);
        root.right = buildTree(preorder, s1 - s2 + index + 1, e1, inorder, index + 1, e2);

        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}

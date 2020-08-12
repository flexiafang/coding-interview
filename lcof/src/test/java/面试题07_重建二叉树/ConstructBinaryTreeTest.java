package 面试题07_重建二叉树;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TreeNode;

/**
 * @Author hustffx
 * @Date 2020/8/12
 */
public class ConstructBinaryTreeTest {

    private ConstructBinaryTree solution;
    private int[] preorder;
    private int[] inorder;
    private TreeNode expected;

    @Before
    public void setUp() throws Exception {
        solution = new ConstructBinaryTree();
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        expected = TreeNode.addAll(3, 9, null, null, 20, 15, 7);
    }

    @Test
    public void buildTree() {
        Assert.assertEquals(expected.toString(), solution.buildTree(preorder, inorder).toString());
    }
}
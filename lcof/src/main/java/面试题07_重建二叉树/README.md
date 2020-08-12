# [面试题07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

## 题目描述

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回如下的二叉树：

```
  3
 / \
9  20
  /  \
 15   7
```

**限制：**

```
0 <= 节点个数 <= 5000
```

## 解法

```java
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
```

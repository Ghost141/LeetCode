package traing.prob105;

import traing.common.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return _build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode _build(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode rootNode = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNode.val) {
                rootNode.left = _build(preorder, preStart + 1, inorder, inStart, i - 1);
                rootNode.right = _build(preorder, preStart + i - inStart + 1, inorder, i + 1, inEnd);
            }
        }
        return rootNode;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        s.buildTree(new int[] {1, 2, 4, 5, 3}, new int[] {4, 2, 5, 1, 3});
        s.buildTree(new int[] {1, 2, 3}, new int[] {3, 2, 1});
    }
}

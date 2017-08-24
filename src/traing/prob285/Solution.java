package traing.prob285;

import traing.TreeNode;

/**
 * Inorder Successor in BST
 * Link: https://leetcode.com/problems/inorder-successor-in-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode l = inorderSuccessor(root.left, p);
            if (l != null) {
                if (l.val > root.val) return root;
                else return l;
            } else return root;
        }
    }
}

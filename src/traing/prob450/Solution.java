package traing.prob450;

import traing.common.TreeNode;

/**
 * Delete Node In a BST
 * Link: https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/19/17
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            TreeNode max = findMax(root.left);
            root.val = max.val;
            deleteNode(root.left, max.val);
        }
        return root;
    }

    private TreeNode findMax(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }
}

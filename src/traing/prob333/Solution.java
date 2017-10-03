package traing.prob333;

import traing.common.TreeNode;

/**
 * Largest BST Subtree
 * Link: https://leetcode.com/problems/largest-bst-subtree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/3/17
 */
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (isValidBST(root, null, null)) return count(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        else return count(root.left) + count(root.right) + 1;
    }
}

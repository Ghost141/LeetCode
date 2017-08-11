package traing.prob230;

import traing.TreeNode;

/**
 * Kth Smallest Element in a BST
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    private int count;
    private int number;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfsFind(root);
        return number;
    }

    private void dfsFind(TreeNode node) {
        if (node.left != null) dfsFind(node.left);
        count--;

        if (count == 0) {
            number = node.val;
            return;
        }
        if (node.right != null) dfsFind(node.right);
    }
}

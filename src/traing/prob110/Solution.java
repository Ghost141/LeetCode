package traing.prob110;

import traing.common.TreeNode;

/**
 * Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        final int heightLeft = height(node.left);
        if (heightLeft != -1) {
            final int heightRight = height(node.right);
            if (heightRight != -1) {
                return Math.abs(heightRight - heightLeft) > 1 ? -1 : (Math.max(heightRight, heightLeft) + 1);
            }
        }
        return -1;
    }
}

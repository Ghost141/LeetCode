package traing.prob222;

import traing.TreeNode;

/**
 * Count Complete Tree Nodes
 * Link: https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/27/17
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        return h == -1 ? 0 : (getHeight(root.right) < h ?
                (1 << h) + countNodes(root.right)
                : (1 << h - 1) + countNodes(root.left));
    }

    private int getHeight(TreeNode node) {
        return node == null ? -1 : 1 + getHeight(node.left);
    }
}

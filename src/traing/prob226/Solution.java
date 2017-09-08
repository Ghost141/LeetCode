package traing.prob226;

import traing.common.TreeNode;

/**
 * Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = root.left, r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);

        return root;
    }

}

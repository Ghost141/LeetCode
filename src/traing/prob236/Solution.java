package traing.prob236;

import traing.common.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        TreeNode lcaLeft = lowestCommonAncestor(root.left, p, q),
                lcaRight = lowestCommonAncestor(root.right, p, q);
        return lcaLeft == null ? lcaRight : (lcaRight == null ? lcaLeft : root);
    }
}

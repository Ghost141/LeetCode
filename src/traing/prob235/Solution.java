package traing.prob235;

import traing.common.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;

        s.lowestCommonAncestor(root, root, left);
    }
}

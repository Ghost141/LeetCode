package traing.prob114;

import traing.common.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 * Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/15/17
 */
public class Solution {
    public void flatten(TreeNode root) {
        build(root, null);
    }
    private TreeNode build(TreeNode root, TreeNode rightRoot) {
        if (root == null) return rightRoot;
        TreeNode newRight = build(root.right, rightRoot);
        rightRoot = build(root.left, newRight);
        root.left = null;
        root.right = rightRoot;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode tree = new TreeNode(1,
                new TreeNode(5),
                new TreeNode(3)
        );
        tree = new TreeNode(1,
                null,
                new TreeNode(3, new TreeNode(8), new TreeNode(4)));
        s.flatten(tree);

        System.out.println(tree);
    }
}

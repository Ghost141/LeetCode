package traing.prob156;

import traing.common.TreeNode;

/**
 * Binary Tree Upside Down
 * Link: https://leetcode.com/problems/binary-tree-upside-down/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.upsideDownBinaryTree(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3))));
    }
}

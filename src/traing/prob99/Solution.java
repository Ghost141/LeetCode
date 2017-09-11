package traing.prob99;

import traing.common.TreeNode;

/**
 * Recover Binary Search Tree
 * Link: https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode tree = new TreeNode(0, new TreeNode(1), null);
//        TreeNode tree = new TreeNode(5,
//                new TreeNode(3,
//                        new TreeNode(6), new TreeNode(4)),
//                new TreeNode(2));
        s.recoverTree(tree);
        System.out.println(tree);
    }
}

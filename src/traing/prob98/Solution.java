package traing.prob98;

import traing.common.TreeNode;

/**
 * Validate Binary Search Tree
 * Link: https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    private Integer number;

    private boolean inOrder(TreeNode root) {
        if (root == null) return true;
        boolean left = inOrder(root.left);
        if (!left) return false;

        if (number == null) number = root.val;
        else {
            if (number >= root.val) return false;
            number = root.val;
        }

        return inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isValidBST(new TreeNode(5,
                new TreeNode(14,
                        new TreeNode(1), null),
                null
        )));
    }
}

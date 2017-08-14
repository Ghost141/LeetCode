package traing.prob530;

import traing.TreeNode;

/**
 * Minimum Absolute Difference in BST
 * Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/12/17
 */
public class Solution {

    Integer min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        return inOrderTravel(root);
    }

    private int inOrderTravel(TreeNode node) {
        if (node == null) return min;

        inOrderTravel(node.left);

        if (prev != null) {
            min = Math.min(node.val - prev, min);
        }
        prev = node.val;

        return inOrderTravel(node.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getMinimumDifference(new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null))));
    }
}

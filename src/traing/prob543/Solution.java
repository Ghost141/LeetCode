package traing.prob543;

import traing.common.TreeNode;

/**
 * Diameter of Binary Tree
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[1];
        inorderTravel(root, max);
        return max[0];
    }

    private int inorderTravel(TreeNode root, int[] max) {
        if (root == null) return -1;
        int left = inorderTravel(root.left, max);
        int right = inorderTravel(root.right, max);
        max[0] = Math.max(left + right + 2, max[0]);
        return Math.max(left, right) + 1;
    }
}

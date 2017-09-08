package traing.prob124;

import traing.common.TreeNode;

/**
 * Binary Tree Maximum Path Sum
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;

        maxPathDown(root, max);
        return max[0];
    }

    private int maxPathDown(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(maxPathDown(root.left, max), 0);
        int right = Math.max(maxPathDown(root.right, max), 0);
        max[0] = Math.max(left + right + root.val, max[0]);
        return Math.max(left, right) + root.val;
    }
}

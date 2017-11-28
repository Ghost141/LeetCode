package traing.prob687;

import traing.common.TreeNode;

/**
 * Longest Univalue Path
 * Link: https://leetcode.com/problems/longest-univalue-path/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[1];
        travel(root, max);
        return max[0];
    }

    private int travel(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = travel(root.left, max);
        int right = travel(root.right, max);
        int leftLen = 0, rightLen = 0;
        if (root.left != null && root.left.val == root.val) {
            leftLen += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightLen += right + 1;
        }
        max[0] = Math.max(max[0], leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }

}

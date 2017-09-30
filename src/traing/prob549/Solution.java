package traing.prob549;

import traing.common.TreeNode;

/**
 * Binary Tree Longest Consecutive Sequence II
 * Link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/29/17
 */
public class Solution {
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private int longest = 0;

    public int longestConsecutive(TreeNode root) {
        travel(root);
        return longest;
    }

    private int[] travel(TreeNode root) {
        if (root == null) return new int[2];
        int incr = 1, decr = 1;
        int rootVal = root.val;
        if (root.left != null) {
            int leftVal = root.left.val;
            int[] left = travel(root.left);
            if (rootVal == leftVal + 1) decr = left[DECREASE] + 1;
            else if (rootVal == leftVal - 1) incr = left[INCREASE] + 1;
        }
        if (root.right != null) {
            int rightVal = root.right.val;
            int[] right = travel(root.right);
            if (rootVal == rightVal + 1) decr = Math.max(decr, right[DECREASE] + 1);
            else if (rootVal == rightVal - 1) incr = Math.max(right[INCREASE] + 1, incr);
        }
        longest = Math.max(longest, decr + incr - 1);
        return new int[] {incr, decr};
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestConsecutive(new TreeNode(1)));
        System.out.println(s.longestConsecutive(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }
}

package traing.prob108;

import traing.common.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/13/17
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start >= end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        return root;
    }
}

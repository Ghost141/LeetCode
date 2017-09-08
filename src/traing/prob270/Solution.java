package traing.prob270;

import traing.common.TreeNode;

/**
 * Closest Binary Search Tree Value
 * Link: https://leetcode.com/problems/closest-binary-search-tree-value/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        return closest(root, target);
    }

    private Integer closest(TreeNode root, double target) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root.val;

        if (root.val == target) return root.val;
        else if (root.val > target) {
            Integer left = closest(root.left, target);
            if (left != null && Math.abs(target - left) < Math.abs(target - root.val)) return left;
            else return root.val;
        } else {
            Integer right = closest(root.right, target);
            if (right != null && Math.abs(target - right) < Math.abs(target - root.val)) return right;
            else return root.val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.closestValue(new TreeNode(2, new TreeNode(1), null), Integer.MAX_VALUE));
    }
}

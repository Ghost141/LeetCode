package traing.prob437;

import traing.TreeNode;

/**
 * Path Sum III
 * Link: https://leetcode.com/problems/path-sum-iii/description/
 *
 * @author zhaokai
 * @version 1.1
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val)
                + pathSumFrom(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.pathSum(new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2,
                                null, new TreeNode(1))),
                new TreeNode(-3,
                        null, new TreeNode(11))), 8));
    }

}

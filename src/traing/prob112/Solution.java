package traing.prob112;

import traing.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && (hasPathSumFrom(root, sum));
    }

    private boolean hasPathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        } else if (root.right != null || root.left != null) {
            return hasPathSumFrom(root.left, sum - root.val) || hasPathSumFrom(root.right, sum - root.val);
        } else {
            return root.val == sum;
        }
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;

        s.hasPathSum(n1, 1);
    }
}

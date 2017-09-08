package traing.prob404;

import traing.common.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return this.sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else if (isLeft && root.left == null && root.right == null) {
            return root.val;
        } else {
            return this.sum(root.left, true) + this.sum(root.right, false);
        }
    }
}

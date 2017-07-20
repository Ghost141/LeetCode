package traing.prob111;

import traing.TreeNode;

/**
 * Minimum Depth of Binary Tree
 *
 * @author zhaokai
 */
public class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return _min(root, 1);
    }

    private int _min(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }
        int minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        if (root.left != null) {
            minLeft = _min(root.left, level + 1);
        }
        if (root.right != null) {
            minRight = _min(root.right, level + 1);
        }

        return Math.min(minLeft, minRight);
    }
}

package traing.prob104;

import traing.common.TreeNode;

/**
 * Maximum Depth of Binary Tree
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/7/17
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxDepth(new TreeNode(1)));
        System.out.println(s.maxDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(s.maxDepth(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6), new TreeNode(7))),
                new TreeNode(3))));
    }
}

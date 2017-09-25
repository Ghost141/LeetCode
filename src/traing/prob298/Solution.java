package traing.prob298;

import traing.common.TreeNode;

/**
 * Binary Tree Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        return root == null ? 0 : dfs(root, 1, root.val - 10);
    }

    private int dfs(TreeNode root, int count, int preVal) {
        if (root == null) return count;
        count = root.val == preVal + 1 ? count + 1 : 1;
        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(Math.max(left, right), count);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.longestConsecutive(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
//        System.out.println(s.longestConsecutive(new TreeNode(1, new TreeNode(2), null)));
//        System.out.println(s.longestConsecutive(new TreeNode(1, null, null)));
//        System.out.println(s.longestConsecutive(new TreeNode(1,
//                new TreeNode(2,
//                        new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null),
//                null)));
        System.out.println(s.longestConsecutive(new TreeNode(1,
                null,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4,
                                null,
                                new TreeNode(5))))));
    }
}

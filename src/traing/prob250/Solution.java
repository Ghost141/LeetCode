package traing.prob250;

import traing.common.TreeNode;

/**
 * Count Univalue Subtrees
 * Link: https://leetcode.com/problems/count-univalue-subtrees/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        postorder(res, root);
        return res[0];
    }
    private boolean postorder(int[] count, TreeNode root) {
        if (root == null) return true;
        boolean left = postorder(count, root.left);
        boolean right = postorder(count, root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;
            count[0]++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countUnivalSubtrees(new TreeNode(5,
                new TreeNode(1,
                        new TreeNode(5), new TreeNode(5)),
                new TreeNode(5,
                        null, new TreeNode(5)))));
    }
}

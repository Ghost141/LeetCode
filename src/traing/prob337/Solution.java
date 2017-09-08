package traing.prob337;

import traing.common.TreeNode;

/**
 * House Robber III
 * Link: https://leetcode.com/problems/house-robber-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/7/17
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = _rob(root);
        return Math.max(res[0], res[1]);
    }

    private static final int ROB = 1;
    private static final int NOT = 0;

    private int[] _rob(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        else if (root.left == null && root.right == null) {
            res[ROB] = root.val;
            res[NOT] = 0;
        } else {
            int[] leftRob = _rob(root.left);
            int[] rightRob = _rob(root.right);
            res[ROB] = leftRob[NOT] + rightRob[NOT] + root.val;
            res[NOT] = Math.max(leftRob[NOT], leftRob[ROB]) + Math.max(rightRob[NOT], rightRob[ROB]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode tree1 = new TreeNode(3,
                new TreeNode(2,
                        null, new TreeNode(3)),
                new TreeNode(3,
                        null, new TreeNode(1)));
        System.out.println(s.rob(tree1));
    }
}

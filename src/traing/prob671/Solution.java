package traing.prob671;

import traing.common.TreeNode;

/**
 * Second Minimum Node In a Binary Tree
 * Link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 29/12/2017
 */
public class Solution {
    private int min;
    private long res = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return (int) res;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            if (min < node.val && node.val < res) {
                res = node.val;
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
    }
}

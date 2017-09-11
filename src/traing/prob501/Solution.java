package traing.prob501;

import traing.common.TreeNode;
import utils.PrintUtils;

/**
 * Find Mode in Binary Search Tree
 * Link: https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        inOrder(root);
        res = new int[len];
        len = 0;
        currentCount = 0;
        inOrder(root);
        return res;
    }

    private int currentValue;
    private int currentCount;
    private int maxCount = 0;
    private int len = 0;
    private int[] res;

    private void calculate(int val) {
        if (val != currentValue) {
            currentValue = val;
            currentCount = 0;
        }
        currentCount++;
        if (maxCount < currentCount) {
            len = 1;
            maxCount = currentCount;
        } else if (currentCount == maxCount) {
            if (res != null) res[len] = currentValue;
            len++;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        calculate(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null))));
    }
}

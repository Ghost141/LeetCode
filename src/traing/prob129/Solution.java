package traing.prob129;

import traing.TreeNode;

/**
 * Sum Root to Leaf Numbers
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/20/17
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int num) {
        if (node == null) return 0;
        int val = num * 10 + node.val;
        if (node.left == null && node.right == null) return val;
        return sum(node.left, val) + sum(node.right, val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(s.sumNumbers(new TreeNode(1, new TreeNode(2), null)));
        System.out.println(s.sumNumbers(new TreeNode(1, null, null)));
        System.out.println(s.sumNumbers(null));
        System.out.println(s.sumNumbers(new TreeNode(1, new TreeNode(1), null)));
        System.out.println(s.sumNumbers(new TreeNode(1
                , new TreeNode(1, new TreeNode(1), null)
                , new TreeNode(2, null, new TreeNode(2)))));
    }
}

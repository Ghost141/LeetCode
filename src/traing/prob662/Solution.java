package traing.prob662;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Maximum Width of Binary Tree
 * Link: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int level, int order, List<Integer> left, List<Integer> right) {
        if (root == null) return 0;
        if (left.size() == level) {
            left.add(order);
            right.add(order);
        } else right.set(level, order);

        int curWidth = right.get(level) - left.get(level) + 1;
        int leftWidth = dfs(root.left, level + 1, 2 * order, left, right);
        int rightWidth = dfs(root.right, level + 1, 2 * order + 1, left, right);
        return Math.max(curWidth, Math.max(leftWidth, rightWidth));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5), null),
                new TreeNode(2,
                        new TreeNode(1,
                                new TreeNode(2), new TreeNode(4)),
                        null))));
    }
}

package traing.prob513;

import traing.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find Bottom Left Tree Value
 * Link: https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/27/17
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }
}

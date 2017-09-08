package traing.prob145;

import traing.common.TreeNode;

import java.util.*;

/**
 * Binary Tree Postorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorder(root, new ArrayList<>());
    }

    private List<Integer> postorder(TreeNode node, List<Integer> list) {
        if (node == null) return list;

        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
        return list;
    }

    private List<Integer> iterative(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = node;
        while (!stack.isEmpty() || cur != null) {
            while (!isLeaf(cur)) {
                stack.push(cur);
                cur = cur.left;
            }
            if (cur != null) res.add(cur.val);
            while (!stack.isEmpty() && cur == stack.peek().right) {
                cur = stack.pop();
                res.add(cur.val);
            }
            if (stack.isEmpty()) {
                cur = null;
            } else {
                cur = stack.peek().right;
            }
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node == null || node.left == null && node.right == null;
    }
}

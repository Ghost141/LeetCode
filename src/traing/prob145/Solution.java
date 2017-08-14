package traing.prob145;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
}

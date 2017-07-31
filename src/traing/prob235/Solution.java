package traing.prob235;

import traing.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = record(root, p);
        Queue<TreeNode> qQueue = record(root, q);
        TreeNode result = null;

        while (true) {
            TreeNode q1 = qQueue.poll();
            TreeNode p1 = pQueue.poll();
            if (p1 == null || q1 == null || p1.val != q1.val) {
                return result;
            } else {
                result = p1;
            }
        }
    }

    private Queue<TreeNode> record(TreeNode root, TreeNode target) {
        Queue<TreeNode> recordList = new LinkedList<>();
        TreeNode node = root;
        while (true) {
            recordList.add(node);
            if (node.val == target.val) {
                return recordList;
            } else if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;

        s.lowestCommonAncestor(root, root, left);
    }
}

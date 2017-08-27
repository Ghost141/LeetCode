package traing.prob272;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Closest Binary Search Tree Value II
 * Link: https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();

        preorder(list, root, target, k);
        return list;
    }

    private void preorder(List<Integer> list, TreeNode root, double target, int k) {
        if (root == null) return;
        preorder(list, root.left, target, k);

        if (list.size() < k) list.add(root.val);
        else if (Math.abs(target - list.get(0)) > Math.abs(target - root.val)) {
            list.remove(0);
            list.add(root.val);
        }
        preorder(list, root.right, target, k);
    }
}

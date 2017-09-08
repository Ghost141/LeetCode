package traing.prob366;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Leaves of Binary Tree
 * Link: https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/27/17
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        height(root, list);
        return list;
    }

    private int height(TreeNode node, List<List<Integer>> list) {
        if (node == null) return -1;
        int lev = Math.max(height(node.left, list), height(node.right, list)) + 1;
        if (list.size() <= lev) list.add(new ArrayList<>());
        list.get(lev).add(node.val);
        return lev;
    }
}

package traing.prob314;

import traing.common.TreeNode;

import java.util.*;

/**
 * Binary Tree Vertical Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/27/17
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        colQueue.offer(0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer col = colQueue.poll();
            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1);
            }
            List<Integer> list = map.getOrDefault(col, new ArrayList<>());
            list.add(node.val);
            map.put(col, list);
            min = Math.min(min, col);
            max = Math.max(max, col);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key = min; key <= max; key++)
            if (map.containsKey(key)) res.add(map.get(key));
        return res;
    }
}

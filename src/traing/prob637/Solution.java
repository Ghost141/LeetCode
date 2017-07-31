package traing.prob637;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Average of Levels in Binary Tree
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0 - 2017/07/31
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            long sum = 0, count = 0;
            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            result.add((double) (sum / count));
            queue = temp;
        }
        return result;
    }

}

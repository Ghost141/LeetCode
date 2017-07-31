package traing.prob637;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Average of Levels in Binary Tree
 * Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0 - 2017/07/31
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfsCal(root, 0, count, result);

        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }

        return result;
    }

    private void dfsCal(TreeNode node, int level, List<Integer> count, List<Double> result) {
        if (node == null) return;
        if (level < result.size()) {
            result.set(level, result.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            result.add((double) node.val);
            count.add(1);
        }
        dfsCal(node.left, level + 1, count, result);
        dfsCal(node.right, level + 1, count, result);
    }
}

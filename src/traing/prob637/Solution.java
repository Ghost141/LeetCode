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
        if (root == null) return new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        List<Double> result = new ArrayList<>();
        int start = 0, level = 1, end = 1;
        double sum = 0, count = 0;

        while (start != end) {
            final TreeNode node = nodeList.get(start);
            end += add(nodeList, node.left);
            end += add(nodeList, node.right);

            sum += node.val;
            count++;
            if (++start == level) {
                level = end;
                result.add(sum / count);
                sum = count = 0;
            }
        }

        return result;
    }
    private int add(List<TreeNode> nodeList, TreeNode node) {
        if (node != null) {
            nodeList.add(node);
            return 1;
        }
        return 0;
    }

    public static void a(int val) {
        val += 2;
    }
    public static void main(String[] args) {
        int sum = 0;
        a(sum);
        System.out.println(sum);
    }
}

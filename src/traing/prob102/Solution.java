package traing.prob102;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * @author zhaokai
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelValue = new ArrayList<>();

        int start = 0, end = 1, level = 1;

        while (start != end) {
            final TreeNode node = nodeList.get(start);
            end += add(nodeList, node.left);
            end += add(nodeList, node.right);
            levelValue.add(node.val);
            if (++start == level) {
                result.add(levelValue);
                levelValue = new ArrayList<>();
                level = end;
            }
        }

        return result;
    }

    private int add(List<TreeNode> list, TreeNode node) {
        if (node != null) {
            list.add(node);
            return 1;
        }
        return 0;
    }
}

package traing.prob515;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Largest Value in Each Tree Row
 * Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> largest) {
        if (node == null) return;
        if (level < largest.size()) {
            largest.set(level, Math.max(largest.get(level), node.val));
        } else {
            largest.add(node.val);
        }
        dfs(node.left, level + 1, largest);
        dfs(node.right, level + 1, largest);
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3; n1.right = n2;

        System.out.println(s.largestValues(n1));
    }
}

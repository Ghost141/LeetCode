package traing.prob95;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * Link: Unique Binary Search Trees II
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[] G = new List[n + 1];

        List<TreeNode> g0 = new ArrayList<>();
        g0.add(null);

        List<TreeNode> g1 = new ArrayList<>();
        g1.add(new TreeNode(1));

        G[0] = g0;
        G[1] = g1;

        for (int i = 2; i <= n; i++) {
            G[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : G[j - 1]) {
                    for (TreeNode right : G[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = generateOffsetTree(right, j);
                        G[i].add(root);
                    }
                }
            }
        }

        return G[n];
    }

    private TreeNode generateOffsetTree(TreeNode node, int offset) {
        if (node == null) return null;
        TreeNode res = new TreeNode(node.val + offset);
        res.left = generateOffsetTree(node.left, offset);
        res.right = generateOffsetTree(node.right, offset);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generateTrees(3));
    }
}

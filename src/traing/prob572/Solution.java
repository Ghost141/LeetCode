package traing.prob572;

import traing.common.TreeNode;

/**
 * Subtree of Another Tree
 * Link: https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/18/17
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return preorderTravel(s, t);
    }

    private boolean preorderTravel(TreeNode x, TreeNode target) {
        return x != null && (treeEqual(x, target) || treeEqual(x.left, target) || treeEqual(x.right, target));
    }

    private boolean treeEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val && treeEqual(tree1.left, tree2.left) && treeEqual(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isSubtree(
                new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null
                        , new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null
                        , new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, new TreeNode(2), null)))))))))))
                , new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, null
                        , new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1, new TreeNode(2), null))))))));
    }
}

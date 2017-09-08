package traing.prob113;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 * Link: https://leetcode.com/problems/path-sum-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        sum(list, new ArrayList<>(), root, sum);
        return list;
    }

    private void sum(List<List<Integer>> list, List<Integer> path, TreeNode root, int remain) {
        if (root == null) return;
        else if (remain == root.val && root.left == null && root.right == null) {
            path.add(root.val);
            list.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            path.add(root.val);
            sum(list, path, root.left, remain - root.val);
            sum(list, path, root.right, remain - root.val);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7), new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5), new TreeNode(1))));

//        System.out.println(s.pathSum(tree, 22));
        System.out.println(s.pathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
    }
}

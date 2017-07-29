package traing.prob257;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Paths
 * Link: https://leetcode.com/problems/binary-tree-paths/description/
 *
 * @author zhaokai
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return _outputPath(root, "");
    }

    private List<String> _outputPath(TreeNode root, String path) {
        if (path.equals("")) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }
        List<String> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(_outputPath(root.left, path));
        }
        if (root.right != null) {
            result.addAll(_outputPath(root.right, path));
        }
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        return result;
    }
}

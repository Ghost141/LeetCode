package traing.prob199;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * Link: https://leetcode.com/problems/binary-tree-right-side-view/tabs/description
 *
 * @author zhaokai
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return _find(nodeList, result);
    }

    private List<Integer> _find(List<TreeNode> nodeList, List<Integer> previous) {
        List<TreeNode> nexLevel = new ArrayList<>();
        previous.add(nodeList.get(nodeList.size() - 1).val);

        for (TreeNode node : nodeList) {
            if (node.left != null) nexLevel.add(node.left);
            if (node.right != null) nexLevel.add(node.right);
        }
        if (nexLevel.isEmpty()) {
            return previous;
        } else {
            return _find(nexLevel, previous);
        }
    }
}

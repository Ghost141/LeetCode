package traing.prob653;

import traing.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Two Sum IV - Input is a BST
 * Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {

    // TODO: There is a way better solution based on Stack. I will update it later.
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list  = new ArrayList<>();
        inorderTravel(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) return true;
            else if (sum > k) right--;
            else left++;
        }
        return false;
    }

    private void inorderTravel(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTravel(root.left, list);
        list.add(root.val);
        inorderTravel(root.right, list);
    }

}

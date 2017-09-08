package traing.prob437;

import traing.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Path Sum III
 * Link: https://leetcode.com/problems/path-sum-iii/description/
 *
 * @author zhaokai
 * @version 1.1 - Prefix sum version.
 * @since 1.0 - 8/29/17
 */
public class Solution {
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//
//        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//    private int pathSumFrom(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val)
//                + pathSumFrom(root.right, sum - root.val);
//    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        return helper(root, 0, prefixSumMap, sum);
    }

    private int helper(TreeNode node, int currentSum, Map<Integer, Integer> prefixSumMap, int target) {
        if (node == null) return 0;
        currentSum += node.val;
        int res = prefixSumMap.getOrDefault(currentSum - target, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        res += helper(node.left, currentSum, prefixSumMap, target) + helper(node.right, currentSum, prefixSumMap, target);
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.pathSum(new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2,
                                null, new TreeNode(1))),
                new TreeNode(-3,
                        null, new TreeNode(11))), 8));
    }

}

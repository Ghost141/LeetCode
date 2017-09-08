package traing.prob508;

import traing.common.TreeNode;

import java.util.*;

/**
 * Most Frequent Subtree Sum
 * Link: https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {

        HashMap<Integer, Integer> map = new HashMap<>();
        sum(root, map);

        int maxOccr = 0;
        for (Integer count : map.values()) {
            maxOccr = Math.max(maxOccr, count);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccr) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int sum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;

        int sumLeft = sum(root.left, map), sumRight = sum(root.right, map);
        int sum = sumLeft + sumRight + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}

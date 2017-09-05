package traing.prob666;

import utils.DataGenerator;

import java.util.*;

/**
 * Path Sum IV
 * Link: https://leetcode.com/problems/path-sum-iv/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num);
        }

        return sum(map, nums[0], 0);
    }

    private int sum(Map<Integer, Integer> tree, int root, int currentSum) {
        if (!tree.containsKey(root / 10)) return 0;
        int value = root % 10;
        int d = root / 100;
        int p = (root / 10) % 10;
        int left = (d + 1) * 10 + p * 2 - 1;
        int right = (d + 1) * 10 + p * 2;
        currentSum += value;
        int res = 0;
        if (tree.containsKey(left)) res += sum(tree, tree.get(left), currentSum);
        if (tree.containsKey(right)) res += sum(tree, tree.get(right), currentSum);
        if (!tree.containsKey(left) && !tree.containsKey(right)) res = currentSum;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.pathSum(DataGenerator.createIntArray("113, 215, 221")));
//        System.out.println(s.pathSum(DataGenerator.createIntArray("113,221")));
//        System.out.println(s.pathSum(DataGenerator.createIntArray("111,217,221,315,415")));
        System.out.println(s.pathSum(DataGenerator.createIntArray("113,229,349,470,485")));
    }
}

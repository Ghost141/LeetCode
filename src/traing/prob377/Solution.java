package traing.prob377;

import utils.DataGenerator;

/**
 * Combination Sum IV
 * Link: https://leetcode.com/problems/combination-sum-iv/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[1];
        backtrack(count, nums, target, 0);
        return count[0];
    }

    private void backtrack(int[] count, int[] nums, int remain, int start) {
        if (remain == 0) count[0]++;
        else if (remain < 0) return;
        else {
            for (int i = start; i < nums.length; i++) {
                backtrack(count, nums, remain - nums[i], start);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum4(DataGenerator.createIntArray("1,2,3"), 4));
    }
}

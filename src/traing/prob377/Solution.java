package traing.prob377;

import utils.DataGenerator;

/**
 * Combination Sum IV
 * Link: https://leetcode.com/problems/combination-sum-iv/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - DP solution
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum4(DataGenerator.createIntArray("1,2,3"), 4));
    }
}

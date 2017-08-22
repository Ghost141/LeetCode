package traing.prob300;

import traing.Utils;
import utils.DataGenerator;

/**
 * Longest Increasing Subsequence
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j]) max = Math.max(dp[j], max);
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int _lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        Utils.printai(dp);
        return maxans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLIS(DataGenerator.createIntArray("0")));
    }
}

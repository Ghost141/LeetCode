package traing.prob300;

import utils.DataGenerator;

import java.util.Arrays;

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
        return dpAndBS(nums);
    }

    private int dp(int[] nums) {
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

    private int dpAndBS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int ind = Arrays.binarySearch(dp, 0, len, num);
            if (ind < 0) ind = -(ind + 1);
            dp[ind] = num;
            if (ind == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLIS(DataGenerator.createIntArray("0")));
    }
}

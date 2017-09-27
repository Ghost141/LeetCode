package traing.prob312;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Burst Balloons
 * Link: https://leetcode.com/problems/burst-balloons/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Add a dp solution for this problem
 * @since 1.0 - 9/27/17
 */
public class Solution {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] memo = new int[n][n];
        int coins = 0;
        for (int i = 0; i < n; i++) {
            int leftMost = max(1, nums[i], nums, 0, i, memo);
            int rightMost = max(nums[i], 1, nums, i + 1, n, memo);
            coins = Math.max(coins, leftMost + rightMost + nums[i]);
        }
        return coins;
    }

    private int max(int left, int right, int[] nums, int start, int end, int[][] memo) {
        if (start >= end) return 0;
        if (memo[start][end - 1] != 0) return memo[start][end - 1];
        int res = 0;
        for (int i = start; i < end; i++) {
            int multiply = left * right * nums[i];
            int leftMost = max(left, nums[i], nums, start, i, memo);
            int rightMost = max(nums[i], right, nums, i + 1, end, memo);
            res = Math.max(res, leftMost + rightMost + multiply);
        }
        memo[start][end - 1] = res;
        return res;
    }

    private int dp(int[] nums) {
        int[] data = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) if (num > 0) data[n++] = num;
        data[0] = data[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], data[left] * data[i] * data[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxCoins(DataGenerator.createIntArray("8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2")));
        System.out.println(s.maxCoins(DataGenerator.createIntArray("39,27,92,51,36,7,30,98,75,41,50,3,45,6,29,58,73,22,63,88,56,20,36,63,91,23,55,50,63,70,19,37,11,32,19,99,18,55,97,82,8,48,72,76,15,8,86,48,59,41,65,75,62,67,98,61,38,34,68,19,25,6,15,72,92,78,89,49,37,78,59,22,26,72,13,43,35,99,59,47,99,35,79,41,80,64,64,93,85,21,50,13,60,97,29,13,49,70,1,4,38,78,83,14,15,31,57,68,29,54,7,52,15,29,42,26,76,50,15,78,80,97,13,99,39,74,61,81,0,90,19,45,15,61,45,58,29,36,88,0,2,94,11,77,25,89,72,91,56,63,90,10,74,24,9,70,66,25,82,48,91,92,62,82,82,99,19,34,85,39,78,91,49,63,30,7,22,13,78,63,87,53,14,55,1,36,2,65,74,36,25,27,23,67,72,14,3,65,46,10,58")));
    }
}

package traing.prob312;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Burst Balloons
 * Link: https://leetcode.com/problems/burst-balloons/description/
 *
 * @author zhaokai
 * @version 1.0
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

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxCoins(DataGenerator.createIntArray("8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2")));
    }
}

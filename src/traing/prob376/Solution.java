package traing.prob376;

import utils.DataGenerator;

/**
 * Wiggle Subsequence
 * Link: https://leetcode.com/problems/wiggle-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j< i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1]);
                } else if (nums[j] < nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0]);
                }
            }
            dp[i][0]++;
            dp[i][1]++;
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wiggleMaxLength(DataGenerator.createIntArray("1")));
        System.out.println(s.wiggleMaxLength(DataGenerator.createIntArray("1,17,5,10,13,15,10,5,16,8")));
    }
}

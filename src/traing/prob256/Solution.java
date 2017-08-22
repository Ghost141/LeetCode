package traing.prob256;

import utils.DataGenerator;

/**
 * Paint House
 * Link: https://leetcode.com/problems/paint-house/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0] = costs[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][j];
                }
            }
        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minCost(DataGenerator.createIntMatrix("5,8,6|19,14,13|7,5,12|14,15,17|3,20,10")));
    }
}

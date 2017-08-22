package traing.prob265;

import utils.DataGenerator;

/**
 * Paint House II
 * Link: https://leetcode.com/problems/paint-house-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        dp[0] = costs[0];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE, minInd = 0;
            int[] row = dp[i - 1];
            for (int j = 0; j < k; j++) {
                if (row[j] >= min && row[j] < secMin) {
                    secMin = row[j];
                } else if (row[j] < min) {
                    secMin = min;
                    min = row[j];
                    minInd = j;
                }
            }
            for (int j = 0; j < k; j++) {
                int paintCost = 0;
                if (minInd == j) {
                    paintCost = secMin;
                } else paintCost = min;
                dp[i][j] = costs[i][j] + paintCost;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minCostII(DataGenerator.createIntMatrix("7,19,11,3,7,15,17,5,6,18,1,15,18,11|13,18,18,8,13,12,11,13,4,8,2,4,5,20|14,5,18,4,7,6,1,6,11,6,16,6,13,17|18,17,11,3,12,4,8,6,2,7,10,9,19,3|4,3,2,14,11,15,18,1,17,1,6,14,14,9|9,13,15,14,5,1,1,6,11,15,16,12,10,18|19,2,11,3,13,4,13,7,16,16,20,18,20,8|8,19,20,9,18,13,17,1,2,4,3,20,15,9|9,10,11,6,14,20,4,1,5,15,13,10,13,5|13,11,9,11,9,16,3,19,1,11,6,7,12,13|14,1,15,14,11,12,7,14,12,11,6,9,5,5|")));
    }
}

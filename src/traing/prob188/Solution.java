package traing.prob188;

/**
 * Best Time to Buy and Sell Stock IV
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length / 2) return justBuyAndSold(prices);
        int[][] dp = new int[k + 1][prices.length];
        int max = 0;

        for (int kk = 1; kk <= k; kk++) {
            int tmpMax = dp[kk - 1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[kk][i] = Math.max(dp[kk][i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[kk - 1][i] - prices[i]);
                max = Math.max(max, dp[kk][i]);
            }
        }
        return max;
    }
    private int justBuyAndSold(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++)
            res += Math.max(prices[i] - prices[i - 1], 0);
        return res;
    }
}

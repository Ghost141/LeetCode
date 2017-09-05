package traing.prob123;

/**
 * Best Time to Buy and Sell Stock III
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - The simpler version solution based on this discussion: https://discuss.leetcode.com/topic/5934/is-it-best-solution-with-o-n-o-1
 *              Explanation of this solution is here: https://discuss.leetcode.com/topic/5934/is-it-best-solution-with-o-n-o-1/29?page=2
 * @since 1.0 - 9/5/17
 */
public class Solution {
//    /**
//     * The dp solution based on this discussion: https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
//     * The idea of transmitting for loop to tmp variable is very clever!
//     * @param prices stock prices.
//     * @return Max profit
//     */
//    public int maxProfit(int[] prices) {
//        if (prices.length < 1) return 0;
//        int max = 0;
//        int[][] dp = new int[2][prices.length];
//        for (int k = 0; k < 2; k++) {
//            int tmpMax = (k == 0 ? 0 : dp[k - 1][0]) - prices[0];
//            for (int i = 1; i < prices.length; i++) {
//                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + tmpMax);
//                tmpMax = Math.max((k == 0 ? 0 : dp[k - 1][i]) - prices[i], tmpMax);
//                max = Math.max(max, dp[k][i]);
//            }
//        }
//        return max;
//    }
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sold1 = 0, sold2 = 0;
        for (int price : prices) {
            sold2 = Math.max(sold2, buy2 + price);
            buy2 = Math.max(buy2, sold1 - price);
            sold1 = Math.max(sold1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sold2;
    }
}

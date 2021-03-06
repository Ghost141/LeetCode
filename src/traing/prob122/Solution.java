package traing.prob122;

import utils.DataGenerator;

/**
 * Best Time to Buy and Sell Stock II
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Simple version solution.
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProfit(DataGenerator.createIntArray("6,1,3,2,4,7")));
    }
}

package traing.prob309;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    /**
     * Discussion about this solution: https://discuss.leetcode.com/topic/30421/share-my-thinking-process
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, prev_buy, prev_sell = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}

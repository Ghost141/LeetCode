package traing.prob121;

/**
 * Best Time to Buy and Sell Stock.
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/18/17
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int min = prices[0], max = 0, maxDiff = 0;

        for (int p : prices) {
            if (p < min) {
                min = max = p;
            }
            max = Math.max(max, p);
            maxDiff = Math.max(maxDiff, max - min);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.maxProfit(new int[] {1, 2, 3, 4, 5, 6}));
        System.out.println(s.maxProfit(new int[] {7, 6, 5, 4, 3, 2, 1}));
        System.out.println(s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
}

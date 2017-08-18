package traing.prob322;

import utils.DataGenerator;

/**
 * Coin Change
 * Link: https://leetcode.com/problems/coin-change/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/18/17
 */
public class Solution {
    int[] change;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (change == null) {
            change = new int[amount + 1];
            change[0] = 0;
        }
        if (change[amount] != 0) return change[amount];
        int step = 0;
        for (int i = 0; i < coins.length; i++) {
            int rest = amount - coins[i];
            int curStep = 0;
            if (rest > 0) {
                int next = coinChange(coins, rest);
                if (next == -1) continue;
                curStep = next + 1;
            } else if (rest == 0) {
                curStep = 1;
            } else {
                continue;
            }

            step = step == 0 ? curStep : Math.min(step, curStep);
        }

        change[amount] = step == 0 ? -1 : step;
        return change[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        System.out.println(s.coinChange(DataGenerator.createIntArray("2"), 3));
    }
}

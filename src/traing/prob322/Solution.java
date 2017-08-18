package traing.prob322;

import utils.DataGenerator;

/**
 * Coin Change
 * Link: https://leetcode.com/problems/coin-change/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - The LeetCode official top down dp solution. I don't think it's better than mine...
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

    private int coinChangeTopDown(int[] coins, int amount) {
        if (amount < 1) return 0;
        return topDown(coins, amount, new int[amount + 1]);
    }
    private int topDown(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem] != 0) return count[rem];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = topDown(coins, rem - coin, count);
            if (res >= 0 && res < min) min = res + 1;
        }
        count[rem] = (min == Integer.MAX_VALUE ? -1 : min);
        return count[rem];
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        System.out.println(s.coinChange(DataGenerator.createIntArray("2"), 3));
    }
}

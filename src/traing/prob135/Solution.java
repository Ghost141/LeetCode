package traing.prob135;

import java.util.Arrays;

/**
 * Candy
 * Link: https://leetcode.com/problems/candy/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Using only O(1) space to solve this question.
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public int candy(int[] ratings) {
        return linearSpaceSolution(ratings);
    }

    private int constantSpaceSolution(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int upCount = 0, downCount = 0, oldSlope = 0, candies = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = Integer.compare(ratings[i], ratings[i - 1]);
            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(upCount) + count(downCount) + Math.max(upCount, downCount);
                upCount = 0;
                downCount = 0;
            }
            if (newSlope > 0) upCount++;
            else if (newSlope < 0) downCount++;
            else candies++;
            oldSlope = newSlope;
        }
        candies += count(upCount) + count(downCount) + Math.max(upCount, downCount) + 1;
        return candies;
    }

    private int count(int n) {
        return n * (n + 1) / 2;
    }

    private int linearSpaceSolution(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length; i++)
            if (i > 0 && ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            sum += candies[i];
        }
        return sum;
    }
}

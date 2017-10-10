package traing.prob398;

import java.util.Random;

/**
 * Random Pick Index
 * Link: https://leetcode.com/problems/random-pick-index/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    private int[] nums;
    private Random rand = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int ind = -1, sameCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (ind == -1) ind = i;
                else {
                    double prob = (double) 1 / (++sameCount + 1);
                    if (rand.nextDouble() < prob) ind = i;
                }
            }
        }
        return ind;
    }
}

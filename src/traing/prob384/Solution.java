package traing.prob384;

import java.util.Random;

/**
 * Shuffle an Array
 * Link: https://leetcode.com/problems/shuffle-an-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    private int[] data;
    private Random random = new Random();
    public Solution(int[] nums) {
        data = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return data;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = data.clone();
        for (int i = 1; i < res.length; i++) {
            int j = random.nextInt(i + 1);
            swap(res, i, j);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

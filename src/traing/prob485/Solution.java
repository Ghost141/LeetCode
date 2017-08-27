package traing.prob485;

/**
 * Max Consecutive Ones
 * Link: https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}

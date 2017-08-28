package traing.prob487;

/**
 * Max Consecutive Ones II
 * Link: https://leetcode.com/problems/max-consecutive-ones-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            right++;
            if (nums[i] == 0) {
                left = right;
                right = 0;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }
}

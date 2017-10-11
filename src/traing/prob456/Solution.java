package traing.prob456;

/**
 * 132 Pattern
 * Link: https://leetcode.com/problems/132-pattern/description/
 *
 * @author zhaokai
 * @version 1.0 - Better brute force solution.
 * @since 1.0 - 10/11/17
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int ai = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                ai = Math.min(ai, nums[j]);
                if (ai < nums[k] && nums[k] < nums[j]) return true;
            }
        }
        return false;
    }
}

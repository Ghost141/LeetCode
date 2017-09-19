package traing.prob164;

import java.util.Arrays;

/**
 * Maximum Gap
 * Link: https://leetcode.com/problems/maximum-gap/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) max = Math.max(max, nums[i] - nums[i - 1]);

        return max;
    }
}

package traing.prob456;

import java.util.ArrayList;
import java.util.List;

/**
 * 132 Pattern
 * Link: https://leetcode.com/problems/132-pattern/description/
 *
 * @author zhaokai
 * @version 1.0 - Better brute force solution.
 * @version 1.1 - Searching Intervals
 * @since 1.0 - 10/11/17
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        return betterBruteForce(nums);
    }

    private boolean betterBruteForce(int[] nums) {
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

    private boolean searchingIntervals(int[] nums) {
        List<int[]> ranges = new ArrayList<>();
        int s = 0, i = 1;
        while (i < nums.length) {
            if (nums[i] <= nums[i - 1]) {
                if (s < i - 1) ranges.add(new int[]{nums[s], nums[i - 1]});
                s = i;
            }
            for (int[] range : ranges)
                if (nums[i] > range[0] && nums[i] < range[1]) return true;
            i++;
        }
        return false;
    }
}

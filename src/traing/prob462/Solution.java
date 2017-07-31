package traing.prob462;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            count += (nums[end] - nums[start]);
            start++;
            end--;
        }
        return count;
    }
}

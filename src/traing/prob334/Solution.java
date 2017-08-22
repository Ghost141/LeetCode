package traing.prob334;

/**
 * Increasing Triplet Subsequence
 * Link: https://leetcode.com/problems/increasing-triplet-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE, j =Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= i) i = Math.min(i, num);
            else if (num <= j) j = Math.min(j, num);
            else return true;
        }

        return false;
    }
}

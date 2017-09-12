package traing.prob674;

import utils.DataGenerator;

/**
 * Longest Continuous Increasing Subsequence
 * Link: https://leetcode.com/contest/leetcode-weekly-contest-49/problems/longest-continuous-increasing-subsequence/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, len);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findLengthOfLCIS(DataGenerator.createIntArray("1,3,5,4,7")));
        System.out.println(s.findLengthOfLCIS(DataGenerator.createIntArray("1,3,5,7")));
    }
}

package traing.prob673;

import java.util.Arrays;

/**
 * Number of Longest Increasing Subsequence
 * Link: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/21/17
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        length[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int max = 0, res = 0;
        for (int len : length) max = Math.max(max, len);
        for (int i = 0; i < length.length; i++) {
            if (length[i] == max) res += count[i];
        }
        return res;
    }
}

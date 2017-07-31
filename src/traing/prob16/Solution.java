package traing.prob16;

import java.util.Arrays;

/**
 * 3Sum Closest
 * Link: https://leetcode.com/problems/3sum-closest/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        Arrays.sort(nums);
        final int n = nums.length;
        int sum;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (result == null || Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}

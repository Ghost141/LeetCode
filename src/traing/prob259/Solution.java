package traing.prob259;

import java.util.Arrays;

/**
 * 3Sum Smaller
 * Link: https://leetcode.com/problems/3sum-smaller/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            count += twoPointer(nums, i + 1, target - nums[i]);
        }

        return count;
    }

    private int twoPointer(int[] nums, int start, int target) {
        int end = nums.length - 1, sum = 0;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                sum += end - start;
                start++;
            } else {
                end--;
            }
        }
        return sum;
    }
}

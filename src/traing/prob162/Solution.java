package traing.prob162;

import utils.DataGenerator;

/**
 * Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/description/
 *
 * @author zhaokai
 * @version 1.0 - Linear Scan solution
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        return linearScan(nums);
    }

    private int linearScan(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1]) return i;
        return nums.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

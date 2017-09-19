package traing.prob162;

import utils.DataGenerator;

/**
 * Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) return i;
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}

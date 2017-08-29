package traing.prob154;

import utils.DataGenerator;

/**
 * Find Minimum in Rotated Sorted Array II
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, middle = start + (end - start) / 2;
        while (start != end) {
            if (nums[middle] < nums[end]) end = middle;
            else if (nums[middle] == nums[end]) end--;
            else start = middle + 1;
            middle = (start + end) / 2;
        }
        return nums[middle];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMin(DataGenerator.createIntArray("3,1")));
        System.out.println(s.findMin(new int[]{2, 3, 1, 1}));
        System.out.println(s.findMin(new int[]{5, 1, 1, 1, 2, 2, 3, 4}));
        System.out.println(s.findMin(new int[]{1, 2, 2}));
        System.out.println(s.findMin(new int[]{1, 2, 2, 2}));
        System.out.println(s.findMin(new int[]{2, 1}));
        System.out.println(s.findMin(new int[]{2, 1, 2, 2}));
        System.out.println(s.findMin(new int[]{2, 2, 1, 2}));
    }
}

package traing.prob153;

/**
 * Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 6/27/17
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, middle = (start + end) / 2;
        while (start != end) {
            if (nums[middle] <= nums[end]) {
                end = middle;
            } else {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        return nums[middle];
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.findMin(new int[]{2, 3, 1, 1}));
        System.out.println(s.findMin(new int[]{5, 1, 1, 1, 2, 2, 3, 4}));
        System.out.println(s.findMin(new int[]{1, 2, 2}));
        System.out.println(s.findMin(new int[]{2, 1}));
    }
}

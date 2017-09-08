package traing.prob34;

import utils.PrintUtils;
import utils.DataGenerator;

/**
 * Search for a Range
 * Link: https://leetcode.com/problems/search-for-a-range/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int start = 0, end = nums.length - 1, middle = start + (end - start) / 2;
        int left = 0;
        while (start < end) {
            if (nums[middle] >= target) {
                end = middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            }
            middle = start + (end - start) / 2;
        }
        if (nums[middle] != target) return new int[]{-1, -1};
        left = middle;

        start = 0;
        end = nums.length - 1;
        middle = start + (end - start) / 2;
        while (start < end) {
            if (nums[middle] > target) {
                end = middle;
            } else if (nums[middle] <= target) {
                start = middle + 1;
            }
            middle = start + (end - start) / 2;
        }
        int right = nums[middle] == target ? middle : middle - 1;

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.searchRange(DataGenerator.createIntArray("5,7,7,8,8,8,8,10"), 4));
        PrintUtils.printai(s.searchRange(DataGenerator.createIntArray("5,7,7,8,8,8,8,10"), 8));
        PrintUtils.printai(s.searchRange(DataGenerator.createIntArray("5,7,7,8,8,8,8,10"), 5));
        PrintUtils.printai(s.searchRange(DataGenerator.createIntArray("1,2,3"), 2));
        PrintUtils.printai(s.searchRange(DataGenerator.createIntArray("1,2"), 2));
    }
}

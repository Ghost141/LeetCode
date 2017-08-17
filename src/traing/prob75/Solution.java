package traing.prob75;

import traing.Utils;
import utils.DataGenerator;

/**
 * Sort Colors
 * Link: https://leetcode.com/problems/sort-colors/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public void sortColors(int[] nums) {
        int blue = nums.length - 1, red = 0;
        for (int i = 0; i <= blue; i++) {
            while (nums[i] == 2 && blue != i) swap(nums, i, blue--);
            while (nums[i] == 0 && red != i) swap(nums, i, red++);
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = DataGenerator.createIntArray("2,2");
        s.sortColors(arr);
        Utils.printai(arr);
    }
}

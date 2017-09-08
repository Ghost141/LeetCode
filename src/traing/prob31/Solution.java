package traing.prob31;

import utils.PrintUtils;
import utils.DataGenerator;

/**
 * Next Permutation
 * Link: https://leetcode.com/problems/next-permutation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) break;
        }
        if (i - 1 >= 0) {
            int j = i;
            for (; j < nums.length - 1; j++) {
                if (nums[j] > nums[i - 1] && nums[j + 1] <= nums[i - 1]) break;
            }
            swap(nums, i - 1, j);

        }
        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] data, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(data, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] d = DataGenerator.createIntArray("1,2");

        s.nextPermutation(d);
        PrintUtils.printai(d);
    }
}

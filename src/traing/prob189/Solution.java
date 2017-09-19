package traing.prob189;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        cyclicReplace(nums, k);
    }

    private void cyclicReplace(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    private void reverse(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = DataGenerator.createIntArray("1,2");

        s.rotate(arr, 1);

        PrintUtils.printai(arr);
    }
}

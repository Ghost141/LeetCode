package traing.prob283;

import utils.PrintUtils;

/**
 * Move Zeroes
 * Link: https://leetcode.com/problems/move-zeroes/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }

    private void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        int[] data1 = {1, 2, 3, 0};
        s.moveZeroes(data1);
        PrintUtils.printai(data1);

        int[] data2 = {0, 2, 3, 0};
        s.moveZeroes(data2);
        PrintUtils.printai(data2);

        final int[] data3 = {1, 2, 0, 3, 0};
        s.moveZeroes(data3);
        PrintUtils.printai(data3);

        final int[] data4 = {0, 0, 0};
        s.moveZeroes(data4);
        PrintUtils.printai(data4);

        final int[] data5 = {1, 2, 3};
        s.moveZeroes(data5);
        PrintUtils.printai(data5);
    }
}

package traing.prob645;

import utils.PrintUtils;
import utils.DataGenerator;

/**
 * Set Mismatch
 * Link: https://leetcode.com/problems/set-mismatch/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/30/17
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int dup = 0, mis = 0;
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] < 0) {
                dup = ind + 1;
                continue;
            }
            nums[ind] = -nums[ind];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                mis = i + 1;
            }
        }
        return new int[] {dup, mis};
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.findErrorNums(DataGenerator.createIntArray("1,2,2,4")));
        PrintUtils.printai(s.findErrorNums(DataGenerator.createIntArray("2,3,2")));
    }
}

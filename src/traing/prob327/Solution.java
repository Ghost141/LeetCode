package traing.prob327;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Count of Range Sum
 * Link: https://leetcode.com/problems/count-of-range-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int[] sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) sum[i + 1] = sum[i] + nums[i];

        for (int i = 0; i < sum.length; i++) {

        }
        PrintUtils.printai(sum);
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countRangeSum(DataGenerator.createIntArray("-2,5,-1"), -2, 2));
    }
}

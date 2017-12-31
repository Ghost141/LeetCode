package traing.prob747;

import utils.DataGenerator;

/**
 * Largest Number At Least Twice of Others
 * Link: https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 31/12/2017
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) return nums.length - 1;
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE, maxInd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                if (max != Integer.MIN_VALUE) second = max;
                max = nums[i];
                maxInd = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return second == Integer.MIN_VALUE ? -1 : (max >= 2 * second ? maxInd : -1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.dominantIndex(DataGenerator.createIntArray("3,6,1,0")));
        System.out.println(s.dominantIndex(DataGenerator.createIntArray("0,0,3,2")));
        System.out.println(s.dominantIndex(DataGenerator.createIntArray("1,2,3,4")));
        System.out.println(s.dominantIndex(DataGenerator.createIntArray("1,0")));
    }
}

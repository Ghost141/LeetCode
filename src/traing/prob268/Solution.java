package traing.prob268;

import utils.DataGenerator;

/**
 * Missing Number
 * Link: https://leetcode.com/problems/missing-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.missingNumber(DataGenerator.createIntArray("1,0")));
        System.out.println(s.missingNumber(DataGenerator.createIntArray("0,1")));
    }
}

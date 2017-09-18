package traing.prob53;

import utils.DataGenerator;

/**
 * Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1, _max = max; i < nums.length; i++) {
            _max = Math.max(nums[i], _max + nums[i]);
            max = Math.max(max, _max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxSubArray(DataGenerator.createIntArray("-2,1,-3,4,-1,2,1,-5,4")));
    }
}

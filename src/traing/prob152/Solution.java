package traing.prob152;

import utils.DataGenerator;

/**
 * Maximum Product Subarray
 * Link: https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 1, _max = max, _min = max; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = _min;
                _min = _max;
                _max = tmp;
            }
            _max = Math.max(nums[i], _max * nums[i]);
            _min = Math.min(nums[i], _min * nums[i]);

            max = Math.max(_max, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProduct(DataGenerator.createIntArray("-2,-3,-4")));
    }
}

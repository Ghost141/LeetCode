package traing.prob713;

/**
 * Subarray Product Less Than K
 * Link: https://leetcode.com/problems/subarray-product-less-than-k/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/13/17
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        long multiply = 1;
        int left = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            multiply *= nums[i];
            while (multiply >= k) multiply /= nums[left++];
            count += i - left + 1;
        }
        return count;
    }
}

package traing.prob643;

/**
 * Maximum Average Subarray I
 * Link: https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum;
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            result = Math.max(result, sum + nums[i] - nums[j]);
            sum = sum + nums[i] - nums[j];
        }
        return result / k;
    }
}

package traing.prob523;

/**
 * Continuous Subarray Sum
 * Link: https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) sum[i + 1] += sum[i] + nums[i];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int s = sum[j + 1] - sum[i];
                if (s == k || (k != 0 && s % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

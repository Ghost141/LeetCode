package traing.prob410;

/**
 * Split Array Largest Sum
 * Link: https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/20/17
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        long left = max, right = sum;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isValid(mid, nums, m)) right = mid - 1;
            else left = mid + 1;
        }
        return (int) left;
    }

    private boolean isValid(long maxSum, int[] nums, int m) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                sum = num;
                if (++count > m) return false;
            }
        }
        return true;
    }
}

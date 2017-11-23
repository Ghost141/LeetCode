package traing.prob689;

/**
 * Maximum Sum of 3 Non-Overlapping Subarrays
 * Link: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/23/17
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        int[] sums = new int[nums.length - K + 1];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (i >= K) s -= nums[i - K];
            if (i >= K - 1) sums[i - K + 1] = s;
        }

        int[] left = new int[sums.length], right = new int[sums.length];
        for (int i = 0, best = 0; i < sums.length; i++) {
            if (sums[i] > sums[best]) best = i;
            left[i] = best;
        }
        for (int i = sums.length - 1, best = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = K; j < sums.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || sums[i] + sums[j] + sums[k] > sums[ans[0]] + sums[ans[1]] + sums[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
}

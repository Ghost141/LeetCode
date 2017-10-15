package traing.prob698;

import utils.DataGenerator;

/**
 * Partition to K Equal Sum Subsets
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/15/17
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int volume = sum / k;
        int[] dp = new int[volume + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = volume; i >= num; i--) {
                if (dp[i - num] > 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[volume] >= k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canPartitionKSubsets(DataGenerator.createIntArray("4,3,2,3,5,2,1"), 4));
    }
}

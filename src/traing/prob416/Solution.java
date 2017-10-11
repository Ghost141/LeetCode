package traing.prob416;

/**
 * Partition Equal Subset Sum
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/11/17
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int volume = 0;
        for (int num : nums) volume += num;
        if (volume % 2 != 0) return false;
        volume /= 2;
        boolean[] dp = new boolean[volume + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = volume; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[volume];
    }
}

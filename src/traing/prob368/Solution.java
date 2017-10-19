package traing.prob368;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest Divisible Subset
 * Link: https://leetcode.com/problems/largest-divisible-subset/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;

        int tmp = nums[maxIndex];
        int curDp = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (tmp % nums[i] == 0 && dp[i] == curDp) {
                curDp--;
                res.add(nums[i]);
                tmp = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestDivisibleSubset(DataGenerator.createIntArray("2,3,8,9,27")));
    }
}

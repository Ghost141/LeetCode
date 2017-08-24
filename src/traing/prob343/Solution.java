package traing.prob343;

/**
 * Integer Break
 * Link: https://leetcode.com/problems/integer-break/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        else if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int start = 1; start < i / 2 + 1; start++) {
                max = Math.max(max, start * dp[i - start]);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.integerBreak(10));
    }
}

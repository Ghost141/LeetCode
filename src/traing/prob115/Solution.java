package traing.prob115;

/**
 * Distinct Subsequences
 * Link: https://leetcode.com/problems/distinct-subsequences/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/15/17
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) dp[i][0] = 1;

        for (int j = 0; j < t.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                else dp[i + 1][j + 1] = dp[i][j + 1];
            }
        }
        return dp[s.length()][t.length()];
    }
}

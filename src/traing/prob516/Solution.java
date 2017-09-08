package traing.prob516;

/**
 * Longest Palindromic Subsequence
 * Link: https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindromeSubseq("cbbd"));
    }
}

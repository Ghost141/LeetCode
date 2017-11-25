package traing.prob727;

/**
 * Minimum Window Subsequence
 * Link: https://leetcode.com/problems/minimum-window-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/25/17
 */
public class Solution {
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length()][T.length()];
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = S.charAt(i) == T.charAt(0) ? i : -1;
            for (int j = 1; j < T.length(); j++) dp[i][j] = -1;
        }
        for (int j = 1; j < T.length(); j++) {
            int k = -1;
            for (int i = 0; i < S.length(); i++) {
                if (k > -1 && S.charAt(i) == T.charAt(j)) dp[i][j] = k;
                if (dp[i][j - 1] > -1) k = dp[i][j - 1];
            }
        }
        int len = Integer.MAX_VALUE, start = -1;
        for (int i = 0; i < S.length(); i++) {
            if (dp[i][T.length() - 1] != -1 && i - dp[i][T.length() - 1] + 1 < len) {
                len = i - dp[i][T.length() - 1] + 1;
                start = dp[i][T.length() - 1];
            }
        }
        return start != -1 ? S.substring(start, start + len) : "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minWindow("abcdebdde", "bde"));
    }
}

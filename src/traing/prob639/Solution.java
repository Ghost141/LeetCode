package traing.prob639;

/**
 * Decode Ways II
 * Link: https://leetcode.com/problems/decode-ways-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/24/17
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : (s.charAt(0) == '0' ? 0 : 1);
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1);
            char c = s.charAt(i);
            if (c == '*') {
                dp[i + 1] = 9 * dp[i];
                int multi = 0;
                if (prev == '1') multi = 9;
                else if (prev == '2') multi = 6;
                else if (prev == '*') multi = 15;
                dp[i + 1] = (dp[i + 1] + multi * dp[i - 1]) % MOD;
            } else {
                dp[i + 1] = c == '0' ? 0 : dp[i];
                if (prev == '1') dp[i + 1] = (dp[i + 1] + dp[i - 1]) % MOD;
                else if (prev == '2' && c <= '6') dp[i + 1] = (dp[i + 1] + dp[i - 1]) % MOD;
                else if (prev == '*') dp[i + 1] = (dp[i + 1] + (c <= '6' ? 2 : 1) * dp[i - 1]) % MOD;
            }
        }
        return (int) dp[s.length()];
    }
}

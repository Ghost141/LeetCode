package traing.prob91;

import utils.PrintUtils;

/**
 * Decode Ways
 * Link: https://leetcode.com/problems/decode-ways/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/15/17
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            int num = Integer.valueOf(s.substring(i, i + 1));
            int two = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num >= 1 && num <= 9) dp[i + 1] += dp[i];
            if (two >= 10 && two <= 26) dp[i + 1] += dp[i - 1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numDecodings("1"));
        System.out.println(s.numDecodings("0"));
        System.out.println(s.numDecodings("11"));
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("121"));
        System.out.println(s.numDecodings("1212"));
        System.out.println(s.numDecodings("2626"));
    }
}

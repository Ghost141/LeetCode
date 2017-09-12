package traing.prob32;

/**
 * Longest Valid Parentheses
 * Link: https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int longestValidParentheses(String s) {
        return dp(s);
    }

    private int dp(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    private int twoPointer(String s) {
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right--;
            if (left == right) max = Math.max(max, right * 2);
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') right++;
            else left--;
            if (left == right) max = Math.max(max, left * 2);
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}

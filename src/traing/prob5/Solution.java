package traing.prob5;

/**
 * Longest Palindromic Substring
 * Link: https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public String longestPalindrome(String s) {
        return dpSolution(s);
    }

    private String dpSolution(String s) {
        if (s == null || s.length() == 0) return "";
        final int n = s.length();
        boolean[][] p = new boolean[n][n];
        int start = 0, end = 0, maxLen = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                }
                if (p[i][j] && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j + 1;
                }
            }
        }

        return s.substring(start, end);
    }

    private String expandAroundCenter(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindrome("babad"));
        System.out.println(3 / 2);
    }
}

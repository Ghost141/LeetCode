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

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindrome("babad"));
    }
}

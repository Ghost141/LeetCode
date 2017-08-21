package traing.prob409;

/**
 * Longest Palindrome
 * Link: https://leetcode.com/problems/longest-palindrome/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];

        for (int i = 0; i < s.length(); i++) {
            count[getCode(s.charAt(i))]++;
        }
        int len = 0;
        int extra = 0;

        for (int c : count) {
            if (c % 2 == 0) {
                len += c;
            } else {
                len += c - 1;
                extra = 1;
            }
        }

        return len + extra;
    }

    private int getCode(char c) {
        if (c - 'a' >= 0) return c - 'a';
        else return c - 'A' + 26;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("aaAbccccdd"));
    }
}

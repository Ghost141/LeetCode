package traing.prob647;

/**
 * Palindromic Substrings
 * Link: https://leetcode.com/problems/palindromic-substrings/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countAndExpand(s, i, i);
            count += countAndExpand(s, i, i + 1);
        }
        return count;
    }

    private int countAndExpand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}

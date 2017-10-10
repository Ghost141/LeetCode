package traing.prob395;

/**
 * Longest Substring with At Least K Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] < k && count[c - 'a'] != 0) { //count[i] = 0 => c does not exist in the string, skip it.
                for (int j = start; j < end; j++) {
                    if (str[j] == c) {
                        int left = helper(str, start, j, k);
                        int right = helper(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestSubstring("aaabb", 3));
    }
}

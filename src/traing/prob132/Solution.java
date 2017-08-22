package traing.prob132;

/**
 * Palindrome Partitioning II
 * Link: https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n + 1];
        for (int i = 0; i <= n; i++) cuts[i] = i - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++)
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j] + 1);
            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++)
                cuts[i + j + 1] = Math.min(cuts[i + j + 1], cuts[i - j + 1] + 1);
        }
        return cuts[n];
    }
}

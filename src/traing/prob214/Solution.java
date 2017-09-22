package traing.prob214;

import utils.PrintUtils;

/**
 * Shortest Palindrome
 * Link: https://leetcode.com/problems/shortest-palindrome/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/21/17
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int[] table = calculateTable(s);

        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    private int[] calculateTable(String s) {
        StringBuilder builder = new StringBuilder(s);
        String transferred = s + '#' + builder.reverse().toString();
        int[] table = new int[transferred.length()];
        int ind = 0;
        for (int i = 1; i < transferred.length(); i++) {
            if (transferred.charAt(ind) == transferred.charAt(i)) {
                table[i] = table[i - 1] + 1;
                ind++;
            } else {
                ind = table[i - 1];
                while (ind > 0 && transferred.charAt(ind) != transferred.charAt(i)) ind = table[ind - 1];
                if (transferred.charAt(ind) == transferred.charAt(i)) ind++;
                table[i] = ind;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        PrintUtils.printai(s.calculateTable("ababa"));
    }
}

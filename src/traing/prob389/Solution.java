package traing.prob389;

/**
 * Find the Difference
 * Link: https://leetcode.com/problems/find-the-difference/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/20/17
 */

public class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        c ^= t.charAt(t.length() - 1);

        return c;
    }
}

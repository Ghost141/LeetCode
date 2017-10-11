package traing.prob455;

import java.util.Arrays;

/**
 * Assign Cookies
 * Link: https://leetcode.com/problems/assign-cookies/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/11/17
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;
        for (; i < g.length && j < s.length;) {
            if (s[j] >= g[i]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}

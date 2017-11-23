package traing.prob670;

/**
 * Maximum Swap
 * Link: https://leetcode.com/problems/maximum-swap/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/23/17
 */
public class Solution {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < s.length; i++) last[s[i] - '0'] = i;
        for (int i = 0; i < s.length; i++) {
            for (char c = '9'; c > s[i] && c >= '0'; c--) {
                if (last[c - '0'] > i) {
                    char tmp = s[i];
                    s[i] = s[last[c - '0']];
                    s[last[c - '0']] = tmp;
                    return Integer.valueOf(new String(s));
                }
            }
        }
        return num;
    }
}

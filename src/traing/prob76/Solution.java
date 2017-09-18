package traing.prob76;

/**
 * Minimum Window Substring
 * Link: https://leetcode.com/problems/minimum-window-substring/description/
 *
 * A very good discussion here: https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/2
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) map[t.charAt(i)]++;
        int counter = t.length(), begin = 0, end = 0, len = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) counter--;
            while (counter == 0) {
                if (len > end - begin) {
                    len = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0) counter++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.minWindow("AAAABCD", "ABCD"));
        System.out.println(s.minWindow("a", "a"));
    }
}

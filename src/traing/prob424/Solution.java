package traing.prob424;

/**
 * Longest Repeating Character Replacement
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * @author zhaokai
 * @version 1.0 - Discussion link: https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation/14
 * @since 1.0 - 10/11/17
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int max = 0;
        int[] count = new int[26];
        for (; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 > max + k) count[s.charAt(start++) - 'A']--;
        }
        return s.length() - start;
    }
}

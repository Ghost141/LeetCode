package traing.prob159;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring with At Most Two Distinct Characters
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.contains(c) && set.size() == 2) {
                    set.clear();
                    break;
                }
                else set.add(c);
                max = Math.max(j - i + 1, max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstringTwoDistinct("abcbcbc"));
    }
}

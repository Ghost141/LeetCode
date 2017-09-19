package traing.prob159;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0;
        while (high < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(high), high);
                high++;
            }
            if (map.size() == 3) {
                int min = Integer.MAX_VALUE;
                for (Integer ind : map.values()) min = Math.min(min, ind);
                low = min + 1;
                map.remove(s.charAt(min));
            }
            max = Math.max(high - low, max);
        }

        return Math.max(high - low, max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.lengthOfLongestSubstringTwoDistinct("abcbcbc"));
        System.out.println(s.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}

package traing.prob340;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most K Distinct Characters
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/7/17
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.size() == k && !map.containsKey(c)) {
                int farest = Integer.MAX_VALUE;
                char farChar = ' ';
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < farest) {
                        farChar = entry.getKey();
                        farest = entry.getValue();
                    }
                }
                len = i - farest;
                map.remove(farChar);
            } else {
                len++;
            }
            map.put(c, i);
            max = Math.max(max, len);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}

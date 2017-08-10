package traing.prob291;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern II
 * Link: https://leetcode.com/problems/word-pattern-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/10/17
 */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {

        return backTrackingIsMatch(pattern, 0, str, 0, new HashMap<>());
    }

    private boolean backTrackingIsMatch(String pattern, int i, String str, int j, Map<Character, String> patternMap) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;

        char c = pattern.charAt(i);
        if (patternMap.containsKey(c)) {
            String match = patternMap.get(c);
            if (!str.startsWith(match, j)) return false;
            return backTrackingIsMatch(pattern, i + 1, str, j + match.length(), patternMap);
        }
        for (int k = j; k < str.length(); k++) {
            String match = str.substring(j, k + 1);
            if (patternMap.containsValue(match)) continue;
            patternMap.put(c, match);
            if (backTrackingIsMatch(pattern, i + 1, str, k + 1, patternMap)) {
                return true;
            }
            patternMap.remove(c);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wordPatternMatch("abab", "redblueredblue"));
    }

}

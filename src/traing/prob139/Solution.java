package traing.prob139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break
 * Link: https://leetcode.com/problems/word-break/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return canBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean canBreak(String s, Set<String> dict, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int i = start; i < s.length(); i++) {
            if (dict.contains(s.substring(start, i + 1)) && canBreak(s, dict, i + 1, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
    }
}

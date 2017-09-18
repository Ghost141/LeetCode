package traing.prob140;

import java.util.*;

/**
 * Word Break II
 * Link: https://leetcode.com/problems/word-break-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> cache = new HashMap<>();
        return wb(s, 0, new HashSet<>(wordDict), cache);
    }

    private List<String> wb(String s, int start, Set<String> dict, Map<Integer, List<String>> cache) {
        if (cache.containsKey(start)) return cache.get(start);
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int end = start; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (dict.contains(sub)) {
                List<String> list = wb(s, end, dict, cache);

                for (String str : list) res.add((sub + " " + str).trim());
            }
        }
        cache.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}

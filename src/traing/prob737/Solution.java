package traing.prob737;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sentence Similarity II
 * Link: https://leetcode.com/problems/sentence-similarity-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            map.computeIfAbsent(pair[0], (w -> new HashSet<>())).add(pair[1]);
            map.computeIfAbsent(pair[1], (w -> new HashSet<>())).add(pair[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i];
            String s2 = words2[i];
            if (!s1.equals(s2)) {
                HashSet<String> visited = new HashSet<>();
                visited.add(s1);
                if (!dfs(s1, s2, map, visited)) return false;
            }
        }
        return true;
    }

    private boolean dfs(String source, String target, Map<String, Set<String>> map, Set<String> visited) {
        if (!map.containsKey(source)) return false;
        for (String word : map.get(source)) {
            if (visited.contains(word)) continue;
            visited.add(word);
            if (word.equals(target)) return true;
            else {
                if (dfs(word, target, map, visited)) return true;
            }
        }
        return false;
    }
}

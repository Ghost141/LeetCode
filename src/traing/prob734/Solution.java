package traing.prob734;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sentence Similarity
 * Link: https://leetcode.com/problems/sentence-similarity/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : words1) map.computeIfAbsent(s, (w -> new HashSet<>())).add(s);
        for (String s : words2) map.computeIfAbsent(s, (w -> new HashSet<>())).add(s);
        for (String[] pair : pairs) {
            map.computeIfAbsent(pair[0], (w -> new HashSet<>())).add(pair[1]);
            map.computeIfAbsent(pair[1], (w -> new HashSet<>())).add(pair[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i];
            String s2 = words2[i];
            if (!s1.equals(s2) && !map.get(s1).contains(s2) && !map.get(s2).contains(s1)) {
                return false;
            }
        }
        return true;
    }
}

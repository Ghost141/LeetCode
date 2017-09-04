package traing.prob244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shortest Word Distance II
 * Link: https://leetcode.com/problems/shortest-word-distance-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, distance = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            distance = Math.min(distance, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return distance;
    }
}

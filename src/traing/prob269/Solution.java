package traing.prob269;

import java.util.*;

/**
 * Alien Dictionary
 * Link: https://leetcode.com/problems/alien-dictionary/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjacentMap = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        if (words == null || words.length == 0) return "";

        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                indegree.put(word.charAt(i), 0);

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                char c1 = words[i].charAt(j);
                char c2 = words[i + 1].charAt(j);
                if (c1 != c2) {
                    Set<Character> set = adjacentMap.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        adjacentMap.put(c1, set);
                        indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                    }
                    break;
                }
            }
        }
        Deque<Character> queue = new ArrayDeque<>();

        for (Character c : indegree.keySet())
            if (indegree.get(c) == 0) queue.offer(c);
        String result = "";
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            Set<Character> neighbors = adjacentMap.get(c);
            result += c;
            if (neighbors == null) continue;
            for (Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        return result.length() == indegree.size() ? result : "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.alienOrder("wrt|wrf|er|ett|rftt".split("\\|")));
    }
}

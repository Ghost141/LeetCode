package traing.prob500;

import java.util.*;

/**
 * Keyboard Row
 * Link: https://leetcode.com/problems/keyboard-row/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/28/17
 */
public class Solution {

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        Map<Integer, Set<Character>> map = new HashMap<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        map.put(1, set1);
        map.put(2, set2);
        map.put(3, set3);
        set1.addAll(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        set2.addAll(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        set3.addAll(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        for (String word : words) {
            Integer line = null;
            boolean add = true;
            String lower = word.toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                if (line == null) {
                    for (int l = 1; l <= 3; l++) {
                        if (map.get(l).contains(lower.charAt(i))) {
                            line = l;
                            break;
                        }
                    }
                } else {
                    if (!map.get(line).contains(lower.charAt(i))) {
                        add = false;
                        break;
                    }
                }
            }
            if (add) res.add(word);
        }
        return res.toArray(new String[0]);
    }
}

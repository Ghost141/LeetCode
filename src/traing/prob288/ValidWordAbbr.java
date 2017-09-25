package traing.prob288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Unique Word Abbreviation
 * Link: https://leetcode.com/problems/unique-word-abbreviation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class ValidWordAbbr {
    private Map<String, Set<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            Set<String> set = map.getOrDefault(abbr, new HashSet<>());
            set.add(word);
            map.put(abbr, set);
        }
    }

    public boolean isUnique(String word) {
        Set<String> set = map.get(getAbbr(word));
        return set == null || (set.size() == 1 && set.contains(word));
    }

    private String getAbbr(String word) {
        if (word.length() <= 2) return word;
        return word.charAt(0) + Integer.toString((word.length() - 2)) + word.charAt(word.length() - 1);
    }

    public static void main(String[] args) {
        ValidWordAbbr s = new ValidWordAbbr("door|naive".split("\\|"));
        System.out.println(s.isUnique("cat"));
    }
}

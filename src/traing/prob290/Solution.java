package traing.prob290;

import traing.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * Link: https://leetcode.com/problems/word-pattern/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/10/17
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] data = str.split(" ");
        if (data.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            char p = pattern.charAt(i);
            String word = data[i];

            if (map.containsKey(p)) {
                if (!map.get(p).equals(word)) return false;
            } else {
                if (map.containsValue(word)) return false;
                else map.put(p, word);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Utils.printStrArr("a b".split(" "));
        Solution s = new Solution();

        System.out.println(s.wordPattern("abba", "dog  cat cat       dog"));
        System.out.println(s.wordPattern("abba", "dog  cat cat apple"));
        System.out.println(s.wordPattern("abbc", "dog  cat cat apple"));
    }
}

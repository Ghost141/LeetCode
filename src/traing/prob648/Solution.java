package traing.prob648;

import java.util.Comparator;
import java.util.List;

/**
 * Replace Words
 * Link: https://leetcode.com/problems/replace-words/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/27/17
 */
public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        dict.sort(Comparator.comparingInt(String::length));
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String d : dict) {
                if (word.startsWith(d)) {
                    words[i] = d;
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word).append(" ");
        }
        return builder.toString().trim();
    }
}

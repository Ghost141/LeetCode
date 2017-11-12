package traing.prob676;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement Magic Dictionary
 * Link: https://leetcode.com/problems/implement-magic-dictionary/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class MagicDictionary {
    private Set<String> set = new HashSet<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) set.add(word);
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != tmp) {
                    chars[i] = c;
                    if (set.contains(new String(chars))) return true;
                }
            }
            chars[i] = tmp;
        }
        return false;
    }
}

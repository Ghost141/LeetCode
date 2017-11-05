package traing.prob720;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Word in Dictionary
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/5/17
 */
public class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(words));
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : Integer.compare(o1.length(), o2.length());
            }
        });
        String res = null;
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i <= word.length(); i++) {
                String sub = word.substring(0, i);
                if (!set.contains(sub)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (res == null) {
                    res = word;
                } else if (res.length() < word.length()) {
                    res = word;
                }
            }
        }
        return res;
    }
}

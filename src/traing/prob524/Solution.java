package traing.prob524;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Longest Word in Dictionary through Deleting
 * Link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/12/17
 */
public class Solution {
    private static final BiFunction<String, String, String> biggerString = (str1, str2) -> {
        if (str1 == null || str2.length() > str1.length() ||
                (str1.length() == str2.length() && str2.compareTo(str1) < 0)) return str2;
        return str1;
    };

    public String findLongestWord(String s, List<String> d) {
        String res = null;
        for (String word : d) if (isSubsequence(s, word)) res = biggerString.apply(res, word);
        return res == null ? "" : res;
    }

    private boolean isSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        int ind1 = 0, ind2 = 0;
        while (ind1 < str1.length()) {
            if (str1.charAt(ind1) == str2.charAt(ind2)) {
                if (++ind2 == str2.length()) break;
            }
            ind1++;
        }
        return ind2 == str2.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}

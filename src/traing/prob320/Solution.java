package traing.prob320;

import java.util.ArrayList;
import java.util.List;

/**
 * Generalized Abbreviation
 * Link: https://leetcode.com/problems/generalized-abbreviation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length();
        if (i == word.length()) {
            if (k != 0) builder.append(k);
            ans.add(builder.toString());
        } else {
            backtrack(ans, builder, word, i + 1, k + 1);

            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generateAbbreviations("word"));
    }
}

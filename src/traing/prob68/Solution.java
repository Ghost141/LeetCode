package traing.prob68;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Text Justification
 * Link: https://leetcode.com/problems/text-justification/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0, k, len; i < words.length; i += k) {
            k = 0;
            len = 0;
            while (i + k < words.length && len + words[i + k].length() <= maxWidth - k) {
                len += words[i + k].length();
                k++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            int spaceLeft = maxWidth - len;
            int slot = k - 1;
            for (int j = i + 1; j < i + k; j++) {
                if (i + k >= words.length) sb.append(" "); // Last line.
                else {
                    int padLen = spaceLeft / slot + (spaceLeft % slot == 0 ? 0 : 1);
                    sb.append(padSpace(padLen));
                    spaceLeft -= padLen;
                    slot--;
                }
                sb.append(words[j]);
            }
            sb.append(padSpace(maxWidth - sb.length()));

            res.add(sb.toString());
        }
        return res;
    }

    private String padSpace(int len) {
        if (len <= 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        p(s.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        p(s.fullJustify(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6));
//        p(s.fullJustify(new String[]{"What", "must", "be", "shall", "be."}, 12));
        p(s.fullJustify(new String[]{"Don't", "go", "around", "saying", "the", "world", "owes", "you", "a", "living;"
                , "the", "world", "owes", "you", "nothing;", "it", "was", "here", "first."}, 30));
        System.out.println("here first.                   |");
    }

    private static void p(List<String> list) {
        for (String s : list) {
            System.out.println(s + "|");
        }
        System.out.println("======================================================================================");
    }
}

package traing.prob151;

/**
 * Reverse Words in a String
 * Link: https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/11/17
 */
public class Solution {
    public String reverseWords(String s) {
        return reverseV1(s);
    }

    /**
     * My solution for this problem.
     * @param s given string.
     * @return reversed string.
     */
    private String reverseV1(String s) {
        String word = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == ' ') {
                if (word.length() > 0) {
                    if (result.length() > 0) {
                        word = word + " ";
                    }
                    result = word + result;
                    word = "";
                }
            } else {
                word += c;
            }
        }

        if (word.length() > 0) {
            if (result.length() > 0) {
                word = word + " ";
            }
            result = word + result;
        }

        return result;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println("|" + s.reverseWords(" ") + "|");
        System.out.println("|" + s.reverseWords("a") + "|");
        System.out.println("|" + s.reverseWords("a ") + "|");
    }
}

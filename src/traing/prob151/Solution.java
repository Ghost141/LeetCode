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
        return inPlaceReverse(s);
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

    /**
     * In-place solution based in this discussion: https://discuss.leetcode.com/topic/3298/in-place-simple-solution/13
     * @param s given string.
     * @return reversed string
     */
    private String inPlaceReverse(String s) {
        if (s.length() <= 1) return s;
        int startInd = 0;
        char[] str = s.toCharArray();
        int n = str.length;
        reverse(str, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (str[i] != ' ') {
                // All these is for not trim the string.
                if (startInd != 0) str[startInd++] = ' ';
                int j = i;
                while (j < n && str[j] != ' ') str[startInd++] = str[j++];
                reverse(str, startInd - (j - i), startInd - 1);
                i = j;
            }
        }
        return new String(str, 0, startInd);
    }

    private void reverse(char[] str, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;
        }
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println("|" + s.reverseWords(" ") + "|");
        System.out.println("|" + s.reverseWords("a") + "|");
        System.out.println("|" + s.reverseWords("a ") + "|");
        System.out.println("|" + s.reverseWords("a bcd efgf") + "|");
    }
}

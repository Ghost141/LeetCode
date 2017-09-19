package traing.prob186;

/**
 * Reverse Words in a String II
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, j, i - 1);
                j = i + 1;
            }
        }
        reverse(s, j, s.length - 1);
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char c = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = c;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String str = "the blue is sky";
        char[] chars = str.toCharArray();
        s.reverseWords(chars);

        System.out.println(new java.lang.String(chars));
    }
}

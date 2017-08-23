package traing.prob345;

/**
 * Reverse Vowels of a String
 * Link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            while (!isVowels(s.charAt(start)) && start < end) start++;
            while (!isVowels(s.charAt(end)) && start < end) end--;
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
        }

        return new String(chars);
    }
    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverseVowels("leetcode"));
        System.out.println(s.reverseVowels("hello"));
    }
}

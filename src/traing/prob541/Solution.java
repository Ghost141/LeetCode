package traing.prob541;

/**
 * Reverse String II
 * Link: https://leetcode.com/problems/reverse-string-ii/tabs/description
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/16/17
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) reverse(chars, i, i + k);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        j = Math.min(chars.length, j) - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }
}

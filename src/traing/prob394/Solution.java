package traing.prob394;

/**
 * Decode String
 * Link: https://leetcode.com/problems/decode-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public String decodeString(String s) {
        return decode(s, new int[] {0}).toString();
    }

    private StringBuilder decode(String s, int[] start) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        for (; start[0] < s.length(); start[0]++) {
            char c = s.charAt(start[0]);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                start[0]++; // Pass current '['
                StringBuilder encoded = decode(s, start);
                while (number-- > 0) {
                    sb.append(encoded);
                }
                number = 0;
            } else if (c == ']') {
                return sb;
            } else {
                sb.append(c);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.decodeString("4[a2[c]f]e2[a]"));
//        System.out.println(s.decodeString("3[a]2[bc]"));
        System.out.println(s.decodeString("10[abc]"));
        System.out.println(s.decodeString("10[abc]").equals("abcabcabcabcabcabcabcabcabcabc"));
    }
}

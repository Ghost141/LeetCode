package traing.prob65;

/**
 * Valid Number
 * Link: https://leetcode.com/problems/valid-number/description/
 *
 * Pass
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] charArray = s.trim().toLowerCase().toCharArray();
        boolean isFloat = false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!isNum(c)) {
                if (c == '.') {
                    if (isFloat) return false;
                    else isFloat = true;
                } else if (c == 'e') {
                    if (i == 0 || i == charArray.length - 1) {
                        return false;
                    }
                } else return false;
            }
        }

        return false;
    }
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isNum('0'));
        System.out.println(s.isNum('9'));
    }
}

package traing.prob8;

/**
 * String to Integer (atoi)
 * Link:https://leetcode.com/problems/string-to-integer-atoi/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public int myAtoi(String str) {
        int result = 0;
        if (str == null || str.equals("")) return 0;
        str = str.trim();
        boolean negative = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            negative = true;
            i = 1;
        } else if (str.charAt(0) == '+') {
            negative = false;
            i = 1;
        }

        for (; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (val < 0 || val > 9) {
                return negative ? -result : result;
            }
            if (!negative) {
                if ((result == Integer.MAX_VALUE / 10 && val > 7) || result > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if ((result == Integer.MAX_VALUE / 10 && val > 8) || result > Integer.MAX_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + val;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.myAtoi("123"));
        System.out.println(s.myAtoi("-123"));
        System.out.println(s.myAtoi(String.valueOf(Integer.MAX_VALUE)));
        System.out.println(s.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(s.myAtoi("21474836471"));
        System.out.println(s.myAtoi("31474836471"));
        System.out.println(s.myAtoi("+"));
        System.out.println(s.myAtoi("1"));
        System.out.println(s.myAtoi("+1123"));
        System.out.println(s.myAtoi("-1"));
        System.out.println(s.myAtoi("-123a123"));
    }
}

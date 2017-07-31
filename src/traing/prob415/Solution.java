package traing.prob415;

/**
 * Add Strings
 * Link: https://leetcode.com/problems/add-strings/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int acc = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = getNum(num1, i) + getNum(num2, j) + acc;
            sb.append(sum % 10);
            acc = sum / 10;
        }
        if (acc > 0) {
            sb.append(acc);
        }

        return sb.reverse().toString();
    }

    private int getNum(String s, int i) {
        if (i >= 0) {
            return s.charAt(i) - '0';
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.addStrings("123", "123"));
        System.out.println(s.addStrings("999", "1"));
        System.out.println(s.addStrings("1", "1999"));
    }
}

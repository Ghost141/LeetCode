package traing.prob43;

/**
 * Multiply Strings
 * Link:https://leetcode.com/problems/multiply-strings/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] position = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j, p2 = p1 + 1;
                int mul = getNum(num1, i) * getNum(num2, j);
                int sum = position[p2] + mul;
                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : position) if (p != 0 || sb.length() != 0) sb.append(p);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    private int getNum(String s, int i) {
        if (i >= 0) {
            return s.charAt(i) - '0';
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("123", "456"));
    }
}

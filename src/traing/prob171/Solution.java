package traing.prob171;

/**
 * Excel Sheet Column Number
 * Link: https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public int titleToNumber(String s) {
        if (s == null) return 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, (s.length() - i - 1));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("B"));
        System.out.println(solution.titleToNumber("Z"));
        System.out.println(solution.titleToNumber("AA"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("BA"));
    }
}

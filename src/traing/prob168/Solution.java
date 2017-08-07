package traing.prob168;

/**
 * Excel Sheet Column Title
 * Link: https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return null;
        String result = "";
        while (n > 0) {
            result = Character.toString((char) ((n - 1) % 26 + 'A')) + result;
            n = (n - 1) / 26;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.convertToTitle(1));
        System.out.println(s.convertToTitle(26));
        System.out.println(s.convertToTitle(27));
        System.out.println(s.convertToTitle(27 + 26));
        System.out.println(s.convertToTitle(27 + 26 + 25));
    }
}

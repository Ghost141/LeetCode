package traing.prob248;

/**
 * Strobogrammatic Number III
 * Link: https://leetcode.com/problems/strobogrammatic-number-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int[] res = new int[1];
        for (int len = low.length(); len <= high.length(); len++) {
            char[] num = new char[len];
            backtracking(num, 0, len - 1, low, high, res);
        }
        return res[0];
    }

    char[][] NUMBERS = new char[][]{
            {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}, {'0', '0'}
    };

    private void backtracking(char[] num, int left, int right, String low, String high, int[] count) {
        if (left > right) {
            String val = String.valueOf(num);
            if ((val.length() != low.length() || val.compareTo(low) >= 0)
                    && (val.length() != high.length() || val.compareTo(high) <= 0)) count[0]++;
        } else {
            for (char[] pair : NUMBERS) {
                if ((num.length != 1 && num[0] == '0') || (left == right && pair[0] != pair[1])) continue;
                num[left] = pair[0];
                num[right] = pair[1];
                backtracking(num, left + 1, right - 1, low, high, count);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.strobogrammaticInRange("1", "1"));
        System.out.println(s.strobogrammaticInRange("50", "100"));
    }
}

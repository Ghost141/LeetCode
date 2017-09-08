package traing.prob66;

import utils.PrintUtils;

/**
 * Plus One
 * Link: https://leetcode.com/problems/plus-one/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n - 1] < 9) {
            digits[n - 1]++;
            return digits;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newRes = new int[n + 1];
        newRes[0] = 1;

        return newRes;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        Utils.printai(s.plusOne(new int[] {1}));
        PrintUtils.printai(s.plusOne(new int[] {9}));
    }
}

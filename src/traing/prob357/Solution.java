package traing.prob357;

/**
 * Count Numbers with Unique Digits
 * Link: https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int digits = 9;
        int available = 9;
        while (n-- > 1 && available > 0) {
            digits = digits * available;
            res += digits;
            available--;
        }
        return res;
    }
}

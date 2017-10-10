package traing.prob400;

/**
 * Nth Digit
 * Link: https://leetcode.com/problems/nth-digit/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * count;
            count *= 10;
            len++;
            start *= 10;
        }
        start += (n - 1) / len;
        return Character.getNumericValue(Integer.toString(start).charAt((n - 1) % len));
    }
}

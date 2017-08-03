package traing.prob263;

/**
 * Ugly Number
 * Link: https://leetcode.com/problems/ugly-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/1/17
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        for (int i = 2; i < 6; i++ )
            while (num % i == 0)
                num /= i;
        return num == 1;
    }
}

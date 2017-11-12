package traing.prob633;

/**
 * Sum of Square Numbers
 * Link: https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for (int i = 0; i <= max; i++) {
            int other = (int) Math.sqrt(c - i * i);
            if (i * i + other * other == c) return true;
        }
        return false;
    }
}

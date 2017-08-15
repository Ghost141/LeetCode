package traing.prob365;

/**
 * Water and Jug Problem
 * Link: https://leetcode.com/problems/water-and-jug-problem/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;

        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}

package traing.prob201;

/**
 * Bitwise AND of Numbers Range
 * Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diffBit = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBit++;
        }
        return m << diffBit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int a = 7, b = 3;
        System.out.println(s.rangeBitwiseAnd(2, 3));
    }
}

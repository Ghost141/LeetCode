package traing.prob191;

/**
 * Number of 1 Bits
 * Link: https://leetcode.com/problems/number-of-1-bits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 6/20/17
 */
public class Solution {
    public int hammingWeight(int x) {
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x = x>>>1;
        }

        return count;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.hammingWeight(Integer.MAX_VALUE + 1));
    }
}

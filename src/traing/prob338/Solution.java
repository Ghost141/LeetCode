package traing.prob338;

/**
 * Counting Bits
 * Link: https://leetcode.com/problems/counting-bits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + i % 2;
        }
        return res;
    }
}

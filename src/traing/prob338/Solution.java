package traing.prob338;

/**
 * Counting Bits
 * Link: https://leetcode.com/problems/counting-bits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - The last set bit solution. Link: https://leetcode.com/problems/counting-bits/solution/
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

    private int[] lastSetBit(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}

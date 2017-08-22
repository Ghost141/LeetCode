package traing.prob598;

import utils.DataGenerator;

/**
 * Range Addition II
 * Link: https://leetcode.com/problems/range-addition-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mMin = Integer.MAX_VALUE, nMin = Integer.MAX_VALUE;
        for (int[] op : ops) {
            mMin = Math.min(op[0], mMin);
            nMin = Math.min(op[1], nMin);
        }
        return mMin == Integer.MAX_VALUE ? m * n : mMin * nMin;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxCount(3, 3, DataGenerator.createIntMatrix("")));
    }
}

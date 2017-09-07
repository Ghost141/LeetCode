package traing.prob446;

import utils.DataGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Arithmetic Slices II - Subsequence
 * Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long _dif =  (long) A[i] - A[j];
                if (_dif <= Integer.MIN_VALUE || _dif > Integer.MAX_VALUE) continue;
                int diff = (int) _dif;
                int count1 = dp[i].getOrDefault(diff, 0);
                int count2 = dp[j].getOrDefault(diff, 0);
                res += count2;
                dp[i].put(diff, count1 + count2 + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfArithmeticSlices(DataGenerator.createIntArray("2,4,6,8,10")));
//        System.out.println(s.numberOfArithmeticSlices(DataGenerator.createIntArray("1,2,3,4,5,6")));
    }
}

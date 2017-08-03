package traing.prob313;

import traing.Utils;

/**
 * Super Ugly Number
 * Link: https://leetcode.com/problems/super-ugly-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/3/17
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] uglyFactor = new int[primes.length];
        for (int i = 0; i < uglyFactor.length; i++) {
            uglyFactor[i] = primes[i];
        }
        int[] primeInd = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = uglyFactor[0];
            for (int j = 1; j < uglyFactor.length; j++) {
                min = Math.min(min, uglyFactor[j]);
            }
            res[i] = min;
            for (int j = 0; j < uglyFactor.length; j++) {
                if (uglyFactor[j] == min) {
                    uglyFactor[j] = res[++primeInd[j]] * primes[j];
                }
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.nthSuperUglyNumber(4, new int[] {2}));
    }
}

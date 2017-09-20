package traing.prob204;

/**
 * Count Primes
 * Link: https://leetcode.com/problems/count-primes/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/20/17
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }
}

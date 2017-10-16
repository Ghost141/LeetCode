package traing.prob667;

/**
 * Beautiful Arrangement II
 * Link: https://leetcode.com/problems/beautiful-arrangement-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/16/17
 */
public class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int ind = 0;
        for (int i = 1; i < n - k; i++) res[ind++] = i;
        for (int i = 0; i <= k; i++) res[ind++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
        return res;
    }
}

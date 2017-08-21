package traing.prob274;

/**
 * H-Index
 * Link: https://leetcode.com/problems/h-index/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n + 1; i++) count[Math.min(citations[i], n)]++;

        int k = n;
        for (int s = count[k]; k > s; s += count[k]) k--;

        return k;
    }
}

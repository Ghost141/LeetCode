package traing.prob96;

/**
 * Unique Binary Search Trees
 * Link: https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int len = 2; len <= n; len++) {
            for (int j = 1; j <= len; j++) {
                G[len] += G[j - 1] * G[len - j];
            }
        }

        return G[n];
    }
}

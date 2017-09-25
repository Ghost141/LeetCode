package traing.prob261;

import utils.DataGenerator;

/**
 * Graph Valid Tree
 * Link: https://leetcode.com/problems/graph-valid-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] id = new int[n];
        int count = n;
        for (int i = 0; i < n; i++) id[i] = i;

        for (int[] edge : edges) {
            int root0 = find(id, edge[0]);
            int root1 = find(id, edge[1]);
            if (root0 == root1) return false;
            id[root1] = root0;
            count--;
        }
        return count == 1;
    }

    private int find(int[] id, int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.validTree(4, DataGenerator.createIntMatrix("0,1|2,3|2,1")));
    }
}

package traing.prob323;

/**
 * Number of Connected Components in an Undirected Graph
 * Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/28/17
 */
public class Solution {
    private int[] root;
    private int count;
    private int[] size;
    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }
        count = n;

        for (int[] edge : edges)
            union(edge[0], edge[1]);
        return count;
    }

    private int find(int p) {
        while (p != root[p]) p = root[p];
        return p;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            root[i] = j;
            size[j] += size[i];
        } else {
            root[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}

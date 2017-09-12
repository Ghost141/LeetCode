package algorithm.graph;

import java.util.Arrays;

/**
 * The Weighted version Union-Find
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class WeightedUnionFind extends BaseUnionFind {
    private int[] size;
    protected WeightedUnionFind(int n) {
        super(n);
        size = new int[n];
        Arrays.fill(size, 1);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (size[p] < size[q]) {
            id[p] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[q] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}

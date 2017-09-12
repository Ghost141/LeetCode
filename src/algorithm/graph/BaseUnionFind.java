package algorithm.graph;

/**
 * Union-Find Algorithm
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public abstract class BaseUnionFind {
    protected int[] id;
    protected int count;

    protected BaseUnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}

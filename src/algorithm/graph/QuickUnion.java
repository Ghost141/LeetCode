package algorithm.graph;

/**
 * The Quick-Union Union-Find.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class QuickUnion extends BaseUnionFind {
    protected QuickUnion(int n) {
        super(n);
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
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}

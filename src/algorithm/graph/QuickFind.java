package algorithm.graph;

/**
 * Quick-Find version Union-Find
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class QuickFind extends BaseUnionFind {
    public QuickFind(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
        count--;
    }
}

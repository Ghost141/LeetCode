package algorithm.graph.topological;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * BFS version topological sort
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/18/17
 */
public class TopologicalSortBFS extends BaseTopologicalSort {
    public int[] sort(int n, int[][] edges) {
        int[] indegree = new int[n], res = new int[n];
        int ind = 0;
        Set<Integer>[] adjacent = new Set[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            if (adjacent[edge[1]] == null) adjacent[edge[1]] = new HashSet<>();
            adjacent[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < indegree.length; i++) if (indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            Integer point = queue.poll();
            res[ind++] = point;
            Set<Integer> ad = adjacent[point];
            if (ad == null) continue;
            for (Integer nei : ad) if (--indegree[nei] == 0) queue.offer(nei);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}

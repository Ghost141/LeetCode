package algorithm.graph.path;

import algorithm.graph.topological.TopologicalSortBFS;

/**
 * Shortest path algorithm for DAG
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/18/17
 */
public class DAGShortestPath extends BasePath {
    public void calculate(int source, int n, int[][] edges) {
        TopologicalSortBFS topo = new TopologicalSortBFS();
        topo.sort(n, edges);
    }
}

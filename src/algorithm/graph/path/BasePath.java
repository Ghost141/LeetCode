package algorithm.graph.path;

/**
 * The base path class.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/18/17
 */
public abstract class BasePath {
    abstract public void calculate(int source, int n, int[][] edges);

    public void initialize(int[] distance, int source) {
        for (int i = 0; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;
    }
}

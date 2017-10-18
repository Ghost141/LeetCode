package algorithm.graph.path;

/**
 * The Bellman-Ford algorithm.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/18/17
 */
public class BellmanFord extends BasePath {
    public void calculate(int source, int n, int[][] edges) {
        int[] distance = new int[n];

        initialize(distance, source);

        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int src = edge[SOURCE];
                int des = edge[DESTNATION];
                int wei = edge[WEIGHT];
                if (distance[src] != Integer.MAX_VALUE && distance[src] + wei < distance[des])
                    distance[des] = distance[src] + wei;
            }
        }

        for (int[] edge : edges) {
            if (distance[edge[SOURCE]] != Integer.MAX_VALUE
                    && distance[edge[SOURCE]] + edge[WEIGHT] < distance[DESTNATION])
                System.err.println("Negative loop found!!!");
        }
    }

    public void initialize(int[] distance, int source) {
        for (int i = 0; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;
    }
}

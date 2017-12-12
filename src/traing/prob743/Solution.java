package traing.prob743;

import utils.DataGenerator;

import java.util.*;

/**
 * Network Delay Time
 * Link: https://leetcode.com/problems/network-delay-time/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/10/17
 */
public class Solution {
    // Typical dijkstra algorithm.
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();
        for (int i = 0; i < times.length; i++)
            adjacentMap.computeIfAbsent(times[i][0], (ArrayList::new)).add(i);
        if (!adjacentMap.containsKey(K)) return -1;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(K);
        while (!queue.isEmpty()) {
            Integer sour = queue.poll();
            int curDis = dist[sour];
            for (Integer neiInd : adjacentMap.getOrDefault(sour, new ArrayList<>())) {
                int dest = times[neiInd][1], cost = times[neiInd][2];
                if (curDis + cost < dist[dest]) {
                    dist[dest] = dist[sour] + cost;
                    queue.offer(dest);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.networkDelayTime(DataGenerator.createIntMatrix("2,1,1|2,3,1|3,4,1"), 4, 2));
        System.out.println(s.networkDelayTime(DataGenerator.createIntMatrix("1,2,1|2,3,2|1,3,4"), 3, 1));
        System.out.println(s.networkDelayTime(DataGenerator.createIntMatrix("1,2,1|2,3,7|1,3,4|2,1,2"), 3, 2));
    }
}

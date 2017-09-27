package traing.prob310;

import utils.DataGenerator;

import java.util.*;

/**
 * Minimum Height Trees
 * Link: https://leetcode.com/problems/minimum-height-trees/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/27/17
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        Set<Integer>[] adjacentMap = new Set[n];
        for (int[] edge : edges) {
            put(adjacentMap, edge[0], edge[1]);
            put(adjacentMap, edge[1], edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < adjacentMap.length; i++)
            if (adjacentMap[i].size() == 1) leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> nextLevelLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer neighbor = adjacentMap[leaf].iterator().next();
                adjacentMap[neighbor].remove(leaf);
                if (adjacentMap[neighbor].size() == 1) nextLevelLeaves.add(neighbor);
            }
            leaves = nextLevelLeaves;
        }
        return leaves;
    }

    private void put(Set<Integer>[] adjacent, int key, int neighbor) {
        if (adjacent[key] == null) {
            adjacent[key] = new HashSet<>();
        }
        adjacent[key].add(neighbor);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMinHeightTrees(6, DataGenerator.createIntMatrix("0,3|1,3|2,3|4,3|5,4")));
    }
}

package traing.prob317;

import utils.DataGenerator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Shortest Distance from All Buildings
 * Link: https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/28/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private static final int[] delta = new int[]{0, 1, 0, -1, 0};
    private int shortest = Integer.MAX_VALUE;

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[][] distance = new int[grid.length][grid[0].length];
        int start = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    bfs(grid, distance, i, j, --start);
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void bfs(int[][] grid, int[][] distance, int row, int col, int start) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        int level = 0;
        shortest = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + point[0];
                    int y = dir[1] + point[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == start) {
                        queue.offer(new int[] {x, y});
                        distance[x][y] += level;
                        shortest = Math.min(shortest, distance[x][y]);
                        grid[x][y]--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.shortestDistance(DataGenerator.createIntMatrix("1,0,2,0,1|0,0,0,0,0|0,0,1,0,0")));
    }
}

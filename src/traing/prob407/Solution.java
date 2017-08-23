package traing.prob407;

import utils.DataGenerator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Trapping Rain Water II
 * Link: https://leetcode.com/problems/trapping-rain-water-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    class Cell implements Comparable<Cell> {
        int x;
        int y;
        int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.h, o.h);
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + "," + h + "}";
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirctions = new int[][]{
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        Queue<Cell> queue = new PriorityQueue<>();
        int space = 0;

        for (int i = 0; i < m; i++) {
            addCell(queue, i, 0, heightMap, visited);
            addCell(queue, i, n - 1, heightMap, visited);
        }

        for (int i = 0; i < n; i++) {
            addCell(queue, 0, i, heightMap, visited);
            addCell(queue, m - 1, i, heightMap, visited);
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirctions) {
                int row = cell.x + dir[0];
                int col = cell.y + dir[1];

                if (row >= 0 && col >= 0 && row < m && col < n && !visited[row][col]) {
                    space += Math.max(0, cell.h - heightMap[row][col]);

                    queue.add(new Cell(row, col, Math.max(heightMap[row][col], cell.h)));
                    visited[row][col] = true;
                }
            }
        }
        return space;
    }

    private void addCell(Queue<Cell> queue, int row, int col, int[][] map, boolean[][] visited) {
        queue.add(new Cell(row, col, map[row][col]));
        visited[row][col] = true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.trapRainWater(DataGenerator.createIntMatrix("12,13,1,12|13,4,13,12|13,8,10,12|12,13,12,12|13,13,13,13")));
        System.out.println(s.trapRainWater(DataGenerator.createIntMatrix("1,4,3,1,3,2|3,2,1,3,2,4|2,3,3,2,3,1")));
    }
}
package traing.prob733;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Flood Fill
 * Link: https://leetcode.com/problems/flood-fill/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];

        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int x = dir[0] + point[0];
                int y = dir[1] + point[1];
                if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && !visited[x][y]) { // inside
                    visited[x][y] = true;
                    if (image[x][y] == color) {
                        image[x][y] = newColor;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printIntMatrix(s.floodFill(DataGenerator.createIntMatrix("1,1,1|1,1,0|1,0,1"), 1, 1, 2));
    }
}

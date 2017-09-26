package traing.prob302;

import utils.DataGenerator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Smallest Rectangle Enclosing Black Pixels
 * Link: https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/26/17
 */
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) return 0;
        Deque<int[]> queue = new ArrayDeque<>();
        int minX = x, minY = y, maxX = x, maxY = y;
        int[][] DIRECTIONS = new int[][] {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[x][y] = true;
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int newX = dir[0] + point[0];
                int newY = dir[1] + point[1];
                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && !visited[newX][newY] && image[newX][newY] == '1') {
                    visited[newX][newY] = true;
                    minX = Math.min(newX, minX);
                    minY = Math.min(newY, minY);
                    maxX = Math.max(newX, maxX);
                    maxY = Math.max(newY, maxY);
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minArea(DataGenerator.createCharBoard("0010|0110|0100"), 0, 2));
    }
}

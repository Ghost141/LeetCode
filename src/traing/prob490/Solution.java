package traing.prob490;

import utils.DataGenerator;

import java.util.ArrayDeque;
import java.util.Deque;

import static utils.DataGenerator.createIntArray;
import static utils.DataGenerator.createIntMatrix;

/**
 * The Maze
 * Link: https://leetcode.com/problems/the-maze/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/30/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if (x == destination[0] && y == destination[1]) return true;
            else {
                for (int[] dir : DIRECTIONS) {
                    int desX = x + dir[0];
                    int desY = y + dir[1];
                    while (desX >= 0 && desX < maze.length && desY >= 0 && desY < maze[0].length
                            && maze[desX][desY] == 0) {
                        desX += dir[0];
                        desY += dir[1];
                    }
                    if (!visited[desX - dir[0]][desY - dir[1]]) {
                        queue.add(new int[] {desX - dir[0], desY - dir[1]});
                        visited[desX - dir[0]][desY - dir[1]] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hasPath(createIntMatrix("0,0,1,0,0|0,0,0,0,0|0,0,0,1,0|1,1,0,1,1|0,0,0,0,0")
                , createIntArray("0,4"), createIntArray("4,4")));
    }
}

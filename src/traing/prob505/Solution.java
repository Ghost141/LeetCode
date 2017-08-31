package traing.prob505;

import java.util.ArrayDeque;
import java.util.Deque;

import static utils.DataGenerator.createIntArray;
import static utils.DataGenerator.createIntMatrix;

/**
 * The Maze II
 * Link: https://leetcode.com/problems/the-maze-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        Deque<Cell> queue = new ArrayDeque<>();
        int[][] mazeStep = new int[maze.length][maze[0].length];
        queue.add(new Cell(start, 0));
        mazeStep[start[0]][start[1]] = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int cX = cell.position[0];
            int cY = cell.position[1];
            if (cX == destination[0] && cY == destination[1]) {
                int finalStep = mazeStep[destination[0]][destination[1]];
                if (finalStep == 0)
                    mazeStep[destination[0]][destination[1]] = cell.distance;
                else
                    mazeStep[destination[0]][destination[1]] = Math.min(finalStep, cell.distance);
            }
            else {
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + cX;
                    int y = dir[1] + cY;
                    int step = 1;

                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        step++;
                    }

                    int desX = x - dir[0];
                    int desY = y - dir[1];
                    step--;
                    if (mazeStep[desX][desY] == 0 || mazeStep[desX][desY] > step + cell.distance) {
                        queue.add(new Cell(new int[] {desX, desY}, step + cell.distance));
                        mazeStep[desX][desY] = cell.distance + step;
                    }
                }
            }
        }
        return mazeStep[destination[0]][destination[1]] == 0 ? -1 : mazeStep[destination[0]][destination[1]];
    }

    class Cell {
        int[] position;
        int distance;

        public Cell(int[] position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.shortestDistance(createIntMatrix("0,0,1,0,0|0,0,0,0,0|0,0,0,1,0|1,1,0,1,1|0,0,0,0,0")
                , createIntArray("0,4"), createIntArray("4,4")));
    }
}

package traing.prob286;

import traing.Utils;
import utils.DataGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Walls and Gates
 * Link: https://leetcode.com/problems/walls-and-gates/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {0, 1},
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, -1}
    );
    public void wallsAndGates(int[][] rooms) {
        int xn = rooms.length;
        if (xn == 0) return;
        int yn = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < xn; i++)
            for (int j = 0; j < yn; j++)
                if (rooms[i][j] == GATE) queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] g = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int x = g[0] + dir[0];
                int y = g[1] + dir[1];
                if ((x < 0 || y < 0 || x == xn || y == yn || rooms[x][y] != EMPTY)) continue;
                rooms[x][y] = rooms[g[0]][g[1]] + 1;
                queue.add(new int[] {x, y});
            }

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] rooms = DataGenerator.createIntMatrix("2147483647,0|0,2147483647");
        s.wallsAndGates(rooms);
        Utils.printIntMatrix(rooms);
    }
}

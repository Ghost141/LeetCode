package traing.prob499;

import utils.PrintUtils;

import java.util.*;

import static utils.DataGenerator.createIntArray;
import static utils.DataGenerator.createIntMatrix;

/**
 * The Maze III
 * Link: https://leetcode.com/problems/the-maze-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private static final char[] DIR_CHAR = {
            'r', 'l', 'd', 'u'
    };

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(ball[0], ball[1], 0, ""));
        List<String> shortes = new ArrayList<>();
        int[][] mazeStep = new int[maze.length][maze[0].length];
        mazeStep[ball[0]][ball[1]] = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.x == hole[0] && cell.y == hole[1]) {
                if (mazeStep[hole[0]][hole[1]] == 0) {
                    shortes.add(cell.path);
                } else if (mazeStep[hole[0]][hole[1]] > cell.dis) {
                    shortes = new ArrayList<>();
                    shortes.add(cell.path);
                } else if (mazeStep[hole[0]][hole[1]] == cell.dis) {
                    shortes.add(cell.path);
                }
            } else {
                for (int i = 0; i < DIRECTIONS.length; i++) {
                    int[] dir = DIRECTIONS[i];
                    char dirChar = DIR_CHAR[i];
                    int x = cell.x + dir[0];
                    int y = cell.y + dir[1];
                    int step = 1;
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && !(x == hole[0] && y == hole[1])) {
                        step++;
                        x += dir[0];
                        y += dir[1];
                    }
                    if (x != hole[0] || y != hole[1]) {
                        x -= dir[0];
                        y -= dir[1];
                        step--;
                    }

                    if ((mazeStep[x][y] == 0 || mazeStep[x][y] >= step + cell.dis) && step != 0) {
                        queue.add(new Cell(x, y, step + cell.dis, cell.path + dirChar));
                        mazeStep[x][y] = cell.dis + step;
                    }
                }
            }
        }

        if (shortes.size() == 0) return "impossible";
        shortes.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return shortes.get(0);
    }

    class Cell {
        int x;
        int y;
        int dis;
        String path;

        public Cell(int x, int y, int dis, String path) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findShortestWay(createIntMatrix("0,1,0,0,1,0,0,1,0,0|0,0,1,0,0,1,0,0,1,0|0,0,0,0,0,0,1,0,0,1|0,0,0,0,0,0,1,0,0,1|0,1,0,0,1,0,0,1,0,0|0,0,1,0,0,1,0,0,0,0|0,0,0,0,0,0,1,0,0,0|1,0,0,1,0,0,0,0,0,1|0,1,0,0,1,0,0,1,0,0|0,0,0,0,0,1,0,0,1,0")
                , createIntArray("2,4"), createIntArray("7,6")));

        PrintUtils.matrix(createIntMatrix("0,1,0,0,1,0,0,1,0,0|0,0,1,0,0,1,0,0,1,0|0,0,0,0,0,0,1,0,0,1|0,0,0,0,0,0,1,0,0,1|0,1,0,0,1,0,0,1,0,0|0,0,1,0,0,1,0,0,0,0|0,0,0,0,0,0,1,0,0,0|1,0,0,1,0,0,0,0,0,1|0,1,0,0,1,0,0,1,0,0|0,0,0,0,0,1,0,0,1,0")
                , createIntArray("2, 4"), createIntArray("7,6"));
    }
}

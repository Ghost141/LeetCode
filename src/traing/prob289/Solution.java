package traing.prob289;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Game of Life
 * Link: https://leetcode.com/problems/game-of-life/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };
    private static final int LIVE = 1;
    private static final int DEAD = 0;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int[] row = new int[board[0].length];
        int prev = 0, left = 0;

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (dir[0] == -1) { // Previous row.
                            if (dir[1] == -1) {
                                if (prev == LIVE) liveCount++;
                            } else {
                                if (row[y] == LIVE) liveCount++;
                            }
                        } else if (dir[0] == 0 && dir[1] == -1) { // Left cell.
                            if (left == LIVE) liveCount++;
                        } else {
                            if (board[x][y] == LIVE) liveCount++;
                        }
                    }
                }
                // Update Up-Left corner cell.
                prev = row[j];
                // Update previous line cell;
                row[j] = board[i][j];
                // Update left cell.
                left = board[i][j];
                if (liveCount < 2 || liveCount > 3) {
                    board[i][j] = DEAD;
                } else {
                    if (board[i][j] == DEAD && liveCount == 3) board[i][j] = LIVE;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] board = DataGenerator.createIntMatrix("0,0,0,0|0,1,1,0|0,1,1,0|0,0,0,0");
        s.gameOfLife(board);
        PrintUtils.printIntMatrix(board);
    }
}

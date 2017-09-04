package traing.prob130;

import traing.Utils;
import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Surrounded Regions
 * Link: https://leetcode.com/problems/surrounded-regions/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    tryFlip(board, visited, i, j);
                }
            }
        }
    }

    private void tryFlip(char[][] board, boolean[][] visited, int x, int y) {
        List<int[]> regionList = new ArrayList<>();
        int start = 0, end = 1;
        regionList.add(new int[]{x, y});
        visited[x][y] = true;
        boolean flip = true;
        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1) flip = false;

        while (start != end) {
            int xx = regionList.get(start)[0];
            int yy = regionList.get(start)[1];
            for (int[] dir : DIRECTIONS) {
                int desX = xx + dir[0];
                int desY = yy + dir[1];
                if (desX >= 0 && desY >= 0 && desX < board.length && desY < board[0].length && !visited[desX][desY]) {
                    // Inside
                    if (board[desX][desY] == 'O') {
                        if (desX == 0 || desY == 0 || desX == board.length - 1 || desY == board[0].length - 1) {
                            flip = false;
                        }
                        regionList.add(new int[]{desX, desY});
                        visited[desX][desY] = true;
                        end++;
                    }
                }
            }
            start++;
        }
        if (flip) {
            for (int[] region : regionList) {
                board[region[0]][region[1]] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        char[][] board = DataGenerator.createCharBoard("XXXX|XOOX|XXOX|XOXX");
//        s.solve(board);
//        Utils.printCharMatrix(board);
        char[][] board = DataGenerator.createCharBoard("OOO|OOO|OOO");
        s.solve(board);
        Utils.printCharMatrix(board);
    }
}

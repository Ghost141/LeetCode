package traing.prob79;

import utils.DataGenerator;

/**
 * Word Search
 * Link: https://leetcode.com/problems/word-search/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                if (helper(board, visited, i, j, "" + board[i][j], word)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }

        return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, int row, int col, String soFar, String word) {
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                String newStr = soFar + board[nextRow][nextCol];
                if (word.equals(newStr)) return true;
                else if (word.indexOf(newStr) == 0) {
                    visited[nextRow][nextCol] = true;
                    if (!helper(board, visited, nextRow, nextCol, newStr, word)) {
                        visited[nextRow][nextCol] = false;
                    } else return true;
                }
            }
        }
        return soFar.equals(word);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.exist(DataGenerator.createCharBoard("ABCE|SFCS|ADEE"), "SEE"));
        System.out.println(s.exist(new char[][] {{'a'}}, "a"));
    }
}

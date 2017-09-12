package traing.prob36;

import utils.DataGenerator;

/**
 * Valid Sudoku
 * Link: https://leetcode.com/problems/valid-sudoku/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9], colUsed = new boolean[9][9], boxUsed = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    Integer num = board[i][j] - '0' - 1;
                    int box = i / 3 * 3 + j / 3;
                    if (rowUsed[i][num] || colUsed[j][num] || boxUsed[box][num]) return false;
                    rowUsed[i][num] = colUsed[j][num] = boxUsed[box][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isValidSudoku(DataGenerator.createCharBoard(".87654321|2........|3........|4........|5........|6........|7........|8........|9........")));
    }
}

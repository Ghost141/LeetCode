package traing.prob51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * N-Queens
 * Link: https://leetcode.com/problems/n-queens/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        gen(res, createEmptyBoard(n), 0, n);
        return res;
    }

    private List<char[]> createEmptyBoard(int n) {
        List<char[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char[] line = new char[n];
            Arrays.fill(line, '.');
            res.add(line);
        }
        return res;
    }

    private void gen(List<List<String>> res, List<char[]> board, int row, int n) {
        if (row == n) {
            List<String> stringBoard = new ArrayList<>();
            for (char[] chars : board)
                stringBoard.add(String.valueOf(chars));
            res.add(stringBoard);
        }
        else {
            for (int i = 0; i < n; i++) {
                if (isValid(board, row, i, n)) {
                    board.get(row)[i] = 'Q';
                    gen(res, board, row + 1, n);
                    board.get(row)[i] = '.';
                }
            }
        }
    }
    private boolean isValid(List<char[]> board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (i != row && board.get(i)[col] == 'Q') return false;
            if (i != col && board.get(row)[i] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board.get(i)[j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board.get(i)[j] == 'Q') return false;
        return true;
    }
}

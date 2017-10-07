package traing.prob348;

/**
 * Design Tic-Tac-Toe
 * Link: https://leetcode.com/problems/design-tic-tac-toe/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/7/17
 */
public class TicTacToe {
    private int[][] board;
    private int[][][] DIRECTIONS = {
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}},
            {{-1, -1}, {1, 1}},
            {{-1, 1}, {1, -1}}
    };
    private int win;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        win = n;
        board = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        for (int[][] dir : DIRECTIONS) {
            int count = 1;

            for (int[] _dir : dir) {
                int x = row + _dir[0];
                int y = col + _dir[1];
                while (x >= 0 && y >= 0 && x < board.length && y < board.length && board[x][y] == player) {
                    count++;
                    x += _dir[0];
                    y += _dir[1];
                }
            }
            if (count >= win) return player;
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe s = new TicTacToe(2);

        System.out.println(s.move(0, 1, 1));
        System.out.println(s.move(1, 1, 2));
        System.out.println(s.move(1, 0, 1));
    }
}

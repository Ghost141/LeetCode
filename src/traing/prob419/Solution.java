package traing.prob419;

/**
 * Battleships in a Board
 * Link: https://leetcode.com/problems/battleships-in-a-board/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i - 1 >= 0 && board[i - 1][j] == 'X') continue;
                if (j - 1 >= 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}

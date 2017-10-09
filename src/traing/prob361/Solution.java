package traing.prob361;

/**
 * Bomb Enemy
 * Link: https://leetcode.com/problems/bomb-enemy/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int max = 0;
        int m = grid.length, n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) if (grid[i][k] == 'E') rowCount++;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCount[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) if (grid[k][j] == 'E') colCount[j]++;
                }
                if (grid[i][j] == '0') max = Math.max(max, rowCount + colCount[j]);
            }
        }
        return max;
    }
}

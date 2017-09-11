package traing.prob463;

/**
 * Island Perimeter
 * Link: https://leetcode.com/problems/island-perimeter/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                int island = grid[i][j];
                if (island == 1) {
                    // Up
                    if (i - 1 >= 0) perimeter += grid[i - 1][j] == 0 ? 1 : 0;
                    else if (i == 0) perimeter++;
                    // Left
                    if (j - 1 >= 0) perimeter += grid[i][j - 1] == 0 ? 1 : 0;
                    else if (j == 0) perimeter++;

                    // Right
                    if (j + 1 < n) perimeter += grid[i][j + 1] == 0 ? 1 : 0;
                    else if (j == n - 1) perimeter++;

                    // Down
                    if (i + 1 < m) perimeter += grid[i + 1][j] == 0 ? 1 : 0;
                    else if (i == m - 1) perimeter++;
                }
            }
        }
        return perimeter;
    }
}

package traing.prob329;

/**
 * Longest Increasing Path in a Matrix
 * Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/3/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, cache, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] cache, int row, int col) {
        if (cache[row][col] != 0) return cache[row][col];
        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[row][col])
                cache[row][col] = Math.max(cache[row][col], dfs(matrix, cache, x, y));
        }
        return ++cache[row][col];
    }
}

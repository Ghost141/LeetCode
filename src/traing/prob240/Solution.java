package traing.prob240;

/**
 * Search a 2D Matrix II
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = m - 1, col = 0;
        while (col <= n - 1 && row >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) col++;
            else if (matrix[row][col] > target) row--;
        }
        return false;
    }
}

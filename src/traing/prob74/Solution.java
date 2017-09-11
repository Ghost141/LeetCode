package traing.prob74;

/**
 * Search a 2D Matrix
 * Link: https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/11/17
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) return true;
            else if (matrix[mid / cols][mid % cols] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}

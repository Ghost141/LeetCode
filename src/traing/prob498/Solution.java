package traing.prob498;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Diagonal Traverse
 * Link: https://leetcode.com/problems/diagonal-traverse/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int row = 0, col = 0;

        int[] res = new int[m * n];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else {
                    row--;col++;
                }
            } else {
                if (col == 0) row++;
                else if (row == m - 1) col++;
                else {
                    row++;col--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.findDiagonalOrder(DataGenerator.createIntMatrix("1,2,3|4,5,6|7,8,9")));
    }
}

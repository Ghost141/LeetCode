package traing.prob59;

import traing.Utils;

/**
 * Spiral Matrix II
 * Link: https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/7/17
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int num = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Left
            for (int i = colBegin; i <= colEnd; i++)
                res[rowBegin][i] = num++;
            rowBegin++;
            // Down
            for (int i = rowBegin; i <= rowEnd; i++)
                res[i][colEnd] = num++;
            colEnd--;
            // Left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--)
                    res[rowEnd][i] = num++;
            }
            rowEnd--;
            // Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--)
                    res[i][colBegin] = num++;
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        Utils.printIntMatrix(s.generateMatrix(1));
        Utils.printIntMatrix(s.generateMatrix(2));
        Utils.printIntMatrix(s.generateMatrix(3));
        Utils.printIntMatrix(s.generateMatrix(4));
        Utils.printIntMatrix(s.generateMatrix(5));
    }
}

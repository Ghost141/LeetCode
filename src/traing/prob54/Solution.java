package traing.prob54;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * Link: https://leetcode.com/problems/spiral-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/7/17
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Right
            for (int i = colBegin; i <= colEnd; i++)
                res.add(matrix[rowBegin][i]);
            rowBegin++;
            // Down
            for (int i = rowBegin; i <= rowEnd; i++)
                res.add(matrix[i][colEnd]);
            colEnd--;
            // Left
            if (rowEnd >= rowBegin) {
                for (int i = colEnd; i >= colBegin; i--)
                    res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            // Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--)
                    res.add(matrix[i][colBegin]);
            }
            colBegin++;

        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.spiralOrder(DataGenerator.createIntMatrix("1,2,3,4|5,6,7,8|9,10,11,12|13,14,15,16")));
        System.out.println(s.spiralOrder(DataGenerator.createIntMatrix("1,2,3|5,6,7|9,10,11|13,14,15")));
        System.out.println(s.spiralOrder(DataGenerator.createIntMatrix("1,2,3|4,5,6|7,8,9")));
        System.out.println(s.spiralOrder(DataGenerator.createIntMatrix("2,3")));
    }
}

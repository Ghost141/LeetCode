package traing.prob304;

/**
 * Range Sum Query 2D - Immutable
 * Link: https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = row == 0 ? 0 : matrix[0].length;
        this.sumMatrix = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix n = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

        System.out.println(n.sumRegion(2, 1, 4, 3));
        System.out.println(n.sumRegion(1, 1, 2, 2));
        System.out.println(n.sumRegion(1, 2, 2, 4));
    }

}

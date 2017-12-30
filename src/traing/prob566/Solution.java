package traing.prob566;

/**
 * Reshape the Matrix
 * Link: https://leetcode.com/problems/reshape-the-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 30/12/2017
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (n * m != r * c) return nums;

        int[][] res = new int[r][c];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                int[] o = transfer(i, j, m, c);
                res[i][j] = nums[o[0]][o[1]];
            }
        }
        return res;
    }

    private int[] transfer(int i, int j, int m, int c) {
        int[] res = new int[2];
        int multi = (i * c) + j;
        res[0] = multi / m;
        res[1] = multi % m;
        return res;
    }
}

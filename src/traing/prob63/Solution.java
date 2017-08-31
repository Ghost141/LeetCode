package traing.prob63;

import traing.Utils;
import utils.DataGenerator;

/**
 * Unique Paths II
 * Link: https://leetcode.com/problems/unique-paths-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        final int WALL = 1;
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 1 : -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == WALL || (i == 0 && j == 0)) continue;
                else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] == -1 ? -1 : 0;
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] == -1 ? -1 : 0;
                } else {
                    obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j]) +
                            (obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1]);
                }
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : -obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("0,0")));
//        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("0,0|0,1")));
//        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("0,1|1,0")));
//        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("0|0|1|0")));
        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("1,0|0,0")));
        System.out.println(s.uniquePathsWithObstacles(DataGenerator.createIntMatrix("0,0|1,1|0,0")));
    }
}

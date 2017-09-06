package traing.prob562;

import static java.lang.Math.max;

/**
 * Longest Line of Consecutive One in Matrix
 * Link: https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/6/17
 */
public class Solution {
    private static final int VERTICAL = 0;
    private static final int HORIZONTAL = 1;
    private static final int DIAGONAL = 2;
    private static final int ANTI_DIAGONAL = 3;

    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int max = 0;
        int[][][] dp = new int[M.length][M[0].length][4];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i][j][VERTICAL] = i - 1 < 0 ? 1 : dp[i - 1][j][VERTICAL] + 1;
                    dp[i][j][HORIZONTAL] = j - 1 < 0 ? 1 : dp[i][j - 1][HORIZONTAL] + 1;
                    dp[i][j][DIAGONAL] = (i - 1 < 0 || j - 1 < 0) ? 1 : dp[i - 1][j - 1][DIAGONAL] + 1;
                    dp[i][j][ANTI_DIAGONAL] = (i - 1 < 0 || j + 1 >= M[0].length) ? 1 : dp[i - 1][j + 1][ANTI_DIAGONAL] + 1;
                    max = max(max, max(dp[i][j][ANTI_DIAGONAL], max(dp[i][j][HORIZONTAL], max(dp[i][j][VERTICAL], dp[i][j][DIAGONAL]))));
                }
            }
        }
        return max;
    }
}

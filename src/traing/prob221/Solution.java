package traing.prob221;

/**
 * Maximal Square
 * Link: https://leetcode.com/problems/maximal-square/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/23/17
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int max = 0;
        int prev = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') dp[j] = Math.min(dp[j], Math.min(prev, dp[j - 1])) + 1;
                else dp[j] = 0;
                max = Math.max(max, dp[j]);
                prev = temp;
            }
        }
        return max * max;
    }
}

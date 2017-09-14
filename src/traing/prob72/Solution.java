package traing.prob72;

/**
 * Edit Distance
 * Link: https://leetcode.com/problems/edit-distance/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    // TODO: Try to improve the space complexity to O(Max(m, n)).
    // There is a hint in this discussion here: https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space/2
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minDistance("", "a"));
    }
}

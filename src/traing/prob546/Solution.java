package traing.prob546;

/**
 * Remove Boxes
 * Link: https://leetcode.com/problems/remove-boxes/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/24/17
 */
public class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0) return 0;
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return remove(boxes, dp, 0, n - 1, 0);
    }

    private int remove(int[] boxes, int[][][] dp, int start, int end, int k) {
        if (start > end) return 0;
        if (dp[start][end][k] > 0) return dp[start][end][k];
        for (; start + 1 <= end && boxes[start + 1] == boxes[start]; start++, k++) ;
        int max = remove(boxes, dp, start + 1, end, 0) + (k + 1) * (k + 1);

        for (int m = start + 1; m <= end; m++) {
            if (boxes[m] == boxes[start])
                max = Math.max(max, remove(boxes, dp, start + 1, m - 1, 0)
                        + remove(boxes, dp, m, end, k + 1));
        }

        dp[start][end][k] = max;
        return max;
    }
}

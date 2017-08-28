package traing.prob279;

/**
 * Perfect Squares
 * Link: https://leetcode.com/problems/perfect-squares/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.numSquares(1));
        System.out.println(s.numSquares(2));
        System.out.println(s.numSquares(3));
        System.out.println(s.numSquares(4));
        System.out.println(s.numSquares(5));
        System.out.println(s.numSquares(6));
        System.out.println(s.numSquares(7));
        System.out.println(s.numSquares(8));
        System.out.println(s.numSquares(9));
        System.out.println(s.numSquares(10));
        System.out.println(s.numSquares(11));
        System.out.println(s.numSquares(12));
    }
}

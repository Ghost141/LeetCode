package traing.prob441;

/**
 * Arranging Coins.
 *
 * @author zhaokai
 */
public class Solution {
    public int arrangeCoins(int n) {
        int start = 0, end = n, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (0.5 * mid * mid + 0.5 * mid <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start - 1;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.arrangeCoins(2147483647));
    }
}

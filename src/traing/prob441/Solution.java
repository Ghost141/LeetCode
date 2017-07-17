package traing.prob441;

/**
 * Arranging Coins.
 *
 * @author zhaokai
 */
public class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            sum += i;
            if (sum == n) {
                return i;
            } else if (sum > n) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.arrangeCoins(2147483647));
    }
}

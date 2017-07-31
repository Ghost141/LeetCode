package traing.prob374;

/**
 * Guess Number Higher or Lower
 * Link: https://leetcode.com/problems/guess-number-higher-or-lower/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution extends GuessGame {
    public Solution(int val) {
        this.val = val;
    }

    public int guessNumber(int n) {
        long low = 1, high = n;
        while (low <= high) {
            int middle = (int) ((high + low) / 2L);
            int res = guess(middle);
            if (res == 0) {
                return middle;
            } else if (res == 1) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final Solution s = new Solution(1702766719);

        System.out.println(s.guessNumber(2126753390));
    }
}

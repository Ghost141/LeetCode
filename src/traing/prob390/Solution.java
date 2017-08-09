package traing.prob390;

/**
 * Elimination Game
 * Link: https://leetcode.com/problems/elimination-game/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/9/17
 */
public class Solution {
    public int lastRemaining(int n) {
        int head = 1, remaining = n, step = 1;
        boolean fromLeft = true;
        while (remaining > 1) {
            if (fromLeft || remaining % 2 == 1) {
                head += step;
            }

            step *= 2;
            fromLeft = !fromLeft;
            remaining /= 2;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lastRemaining(6));
        System.out.println(s.lastRemaining(100000));
    }
}

package traing.prob367;

/**
 * Valid Perfect Square
 * Link: https://leetcode.com/problems/valid-perfect-square/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/27/17
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                high = (int) mid - 1;
            } else {
                low = (int) mid + 1;
            }
        }
        return false;
    }
}

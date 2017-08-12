package traing.prob650;

/**
 * 2 Keys Keyboard
 * Link: https://leetcode.com/problems/2-keys-keyboard/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/12/17
 */
public class Solution {
    public int minSteps(int n) {
        int step = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                step += d;
                n /= d;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minSteps(3));
        System.out.println(s.minSteps(4));
        System.out.println(s.minSteps(5));
    }
}

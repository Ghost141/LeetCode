package traing.prob738;

/**
 * Monotone Increasing Digits
 * Link: https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/3/17
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        char[] chars = String.valueOf(N).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                minus(chars, i);
                update9(chars, i + 1);
                return monotoneIncreasingDigits(Integer.valueOf(new String(chars)));
            }
        }
        return Integer.valueOf(new String(chars));
    }

    private void update9(char[] chars, int start) {
        for (int i = start; i < chars.length; i++) chars[i] = '9';
    }

    private void minus(char[] chars, int end) {
        for (int i = end; i >= 0; i--) {
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i]--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.monotoneIncreasingDigits(332));
        System.out.println(s.monotoneIncreasingDigits(123));
        System.out.println(s.monotoneIncreasingDigits(10000));
    }
}

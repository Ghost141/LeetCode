package traing.prob7;

/**
 * Reverse Integer
 * Link: https://leetcode.com/problems/reverse-integer/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/17/17
 */
public class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean isNegative = x < 0;

        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && (x % 10) > 7)
                    || (res == Integer.MIN_VALUE / 10 && (x % 10) > 8))
                return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

//        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(Integer.MIN_VALUE));
    }
}

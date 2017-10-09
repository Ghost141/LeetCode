package traing.prob693;

/**
 * Binary Number with Alternating Bits
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/8/17
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean bit = (n & 1) == 1;
        n = n >> 1;
        while (n != 0) {
            boolean cur = (n & 1) == 1;
            if (cur == bit) {
                return false;
            } else bit = cur;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hasAlternatingBits(5));
        System.out.println(s.hasAlternatingBits(7));
        System.out.println(s.hasAlternatingBits(1));
        System.out.println(s.hasAlternatingBits(2));
        System.out.println(s.hasAlternatingBits(3));
    }
}

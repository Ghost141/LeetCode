package traing.prob231;

/**
 * Power of Two
 * @author zhaokai
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n < 0) return false;

        while (true) {
            if (n % 2 == 1) {
                return false;
            } else {
                n = n >> 1;
                if (n == 1) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPowerOfTwo(0));
        System.out.println(s.isPowerOfTwo(1));
        System.out.println(s.isPowerOfTwo(2));
        System.out.println(s.isPowerOfTwo(3));
        System.out.println(s.isPowerOfTwo(10));
        System.out.println(s.isPowerOfTwo(16));
    }
}

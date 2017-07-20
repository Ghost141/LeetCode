package traing.prob342;

/**
 * Power of 4
 * @author zhaokai
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        while (true) {
            if (num % 4 != 0) {
                return false;
            } else {
                num = num >> 2;
                if (num == 1) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPowerOfFour(16));
        System.out.println(s.isPowerOfFour(12));
        System.out.println(s.isPowerOfFour(3));
        System.out.println(s.isPowerOfFour(1));
        System.out.println(s.isPowerOfFour(2));
        System.out.println(s.isPowerOfFour(0));
    }
}
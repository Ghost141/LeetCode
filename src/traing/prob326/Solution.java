package traing.prob326;

/**
 * Power of Three
 * @author zhaokai
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;

        while (true) {
            if (n % 3 > 0) {
                return false;
            } else {
                n = n / 3;
                if (n == 1) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPowerOfThree(-1));
        System.out.println(s.isPowerOfThree(0));
        System.out.println(s.isPowerOfThree(1));
        System.out.println(s.isPowerOfThree(2));
        System.out.println(s.isPowerOfThree(3));
        System.out.println(s.isPowerOfThree(4));
        System.out.println(s.isPowerOfThree(9));
    }
}

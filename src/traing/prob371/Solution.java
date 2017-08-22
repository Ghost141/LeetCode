package traing.prob371;

/**
 * Sum of Two Integers
 * Link: https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/9/17
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.getSum(1, 1));
//        System.out.println(s.getSum(0, 1));
//        System.out.println(s.getSum(0, 0));
//        System.out.println(s.getSum(1, 0));
//        System.out.println(s.getSum(2, 2));
//        System.out.println(s.getSum(3, 2));
        System.out.println(s.getSum(-3, 2));
    }
}

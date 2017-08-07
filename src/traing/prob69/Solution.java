package traing.prob69;

/**
 * Sqrt(x)
 * Link: https://leetcode.com/problems/sqrtx/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/6/17
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int start = 0, end = x / 2, middle;

        while (true) {
            middle = (start + end) / 2;
            int res = x / middle;
            if (res == middle) {
                return middle;
            } else if (res > middle) {
                start = middle;
            } else {
                end = middle;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(Integer.MAX_VALUE));
//        System.out.println((int) Math.sqrt(Integer.MAX_VALUE));
        Solution s = new Solution();

        System.out.println(s.mySqrt(Integer.MAX_VALUE - 50000));
        System.out.println(Math.sqrt(Integer.MAX_VALUE - 50000));

        System.out.println(s.mySqrt(46339*46339));
        System.out.println(Math.sqrt(46339*46339));
//        System.out.println(Integer.MAX_VALUE - 50000);
    }
}

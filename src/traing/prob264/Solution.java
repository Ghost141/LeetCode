package traing.prob264;


/**
 * Ugly Number II
 * Link: https://leetcode.com/problems/ugly-number-ii/description/
 *
 * @author zhaokai
 * @version 1.1
 * @since 1.0 - 8/3/17
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int ug2 = 2, ug3 = 3, ug5 = 5;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(ug2, ug3), ug5);
            res[i] = min;
            if (ug2 == min) ug2 = 2 * res[++ind2];
            if (ug3 == min) ug3 = 3 * res[++ind3];
            if (ug5 == min) {
                ug5 = 5 * res[++ind5];
            }
        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.nthUglyNumber(1));
//        System.out.println(s.nthUglyNumber(2));
//        System.out.println(s.nthUglyNumber(3));
//        System.out.println(s.nthUglyNumber(4));
        System.out.println(s.nthUglyNumber(5));
        System.out.println(s.nthUglyNumber(6));
        System.out.println(s.nthUglyNumber(7));
        System.out.println(s.nthUglyNumber(8));
        System.out.println(s.nthUglyNumber(9));
        System.out.println(s.nthUglyNumber(10));
        System.out.println(s.nthUglyNumber(1600));
//        System.out.println(s.nthUglyNumber(1601));
        System.out.println(1399680000);
        System.out.println(Integer.MAX_VALUE);
    }
}

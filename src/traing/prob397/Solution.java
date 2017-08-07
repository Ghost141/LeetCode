package traing.prob397;

/**
 * Integer Replacement
 * Link: https://leetcode.com/problems/integer-replacement/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/8/17
 */
public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            count++;
            if ((n & 1) == 0) {
                n = n >> 1;
            } else {
                if (n % 4 == 3 && n != 3) {
                    n = n >> 1;
                    n++;
                    count++;
                } else n--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.integerReplacement(8));
        System.out.println(s.integerReplacement(1));
        System.out.println(s.integerReplacement(7));
        System.out.println(s.integerReplacement(Integer.MAX_VALUE));
    }
}

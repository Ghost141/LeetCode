package traing.prob651;

/**
 * 4 Keys Keyboard
 * Link: https://leetcode.com/problems/4-keys-keyboard/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    public int maxA(int N) {
        int[] d = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            d[i] = i;
            for (int j = 3; j < i; j++) {
                d[i] = Math.max(d[i], d[i - j] * (j - 1));
            }
        }

        return d[N];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxA(1));
        System.out.println(s.maxA(2));
        System.out.println(s.maxA(3));
        System.out.println(s.maxA(4));
        System.out.println(s.maxA(5));
        System.out.println(s.maxA(6));
        System.out.println(s.maxA(7));
        System.out.println(s.maxA(8));
        System.out.println(s.maxA(9));
        System.out.println(s.maxA(10));
    }
}

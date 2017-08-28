package traing.prob507;

/**
 * Perfect Number
 * Link: https://leetcode.com/problems/perfect-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0 && i != num) {
                sum += i;
                if (i * i < num && i != 1) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.checkPerfectNumber(28));
        System.out.println(s.checkPerfectNumber(1));
    }
}

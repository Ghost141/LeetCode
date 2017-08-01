package traing.prob202;

/**
 * Happy Number
 * Link: https://leetcode.com/problems/happy-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/1/17
 */
public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int calculate(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy(19));
    }
}

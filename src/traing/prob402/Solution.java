package traing.prob402;

/**
 * Remove K Digits
 * Link: https://leetcode.com/problems/remove-k-digits/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/23/17
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        char[] stack = new char[num.length()];
        char[] chars = num.toCharArray();
        int top = -1, count = k;
        for (char c : chars) {
            while (count > 0 && top >= 0 && stack[top] > c) {
                top--; count--;
            }
            stack[++top] = c;
        }
        int i = 0;
        for (; i < stack.length - k; i++) {
            if (stack[i] > '0') break;
        }
        return i == stack.length - k ? "0" : new String(stack, i, stack.length - k - i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeKdigits("1432219", 3));
        System.out.println(s.removeKdigits("10200", 1));
        System.out.println(s.removeKdigits("100200", 2));
        System.out.println(s.removeKdigits("10", 2));
        System.out.println(s.removeKdigits("1234567890", 9));
    }
}

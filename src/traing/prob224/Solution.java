package traing.prob224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Basic Calculator
 * Link: https://leetcode.com/problems/basic-calculator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/21/17
 */
public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0, result = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                result = stack.pop() * result + stack.pop();
                number = 0;
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}

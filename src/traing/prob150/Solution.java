package traing.prob150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(token);
            } else {
                String v2 = stack.pop();
                String v1 = stack.pop();
                stack.push(String.valueOf(eval(token, Integer.valueOf(v1), Integer.valueOf(v2))));
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private int eval(String operator, int v1, int v2) {
        if (operator.equals("+")) {
            return v1 + v2;
        } else if (operator.equals("*")) {
            return v1 * v2;
        } else if (operator.equals("-")) {
            return v1 - v2;
        } else if (operator.equals("/")) {
            return v1 / v2;
        }
        return 0;
    }

    private boolean isInteger(String s) {
        return !s.equals("-") && !s.equals("+") && !s.equals("*") && !s.equals("/");
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

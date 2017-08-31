package traing.prob227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Basic Calculator II
 * Link: https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char op = '+';
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) number = number * 10 + (c - '0');

            if ((!Character.isDigit(c) && c!= ' ') || i == s.length() - 1) {
                if (op == '+') stack.push(number);
                else if (op == '-') stack.push(-number);
                else if (op == '*') {
                    Integer pop = stack.pop();
                    stack.push(pop * number);
                } else if (op == '/') {
                    Integer pop = stack.pop();
                    stack.push(pop / number);
                }
                op = s.charAt(i);
                number = 0;
            }
        }
        int res = 0;
        for (Integer num : stack) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.calculate("5     "));
//        System.out.println(s.calculate("5    "));
//        System.out.println(s.calculate("5   "));
//        System.out.println(s.calculate("5  "));
//        System.out.println(s.calculate("5   "));
        System.out.println(s.calculate(" 12"));
    }
}

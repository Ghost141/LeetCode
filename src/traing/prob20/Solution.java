package traing.prob20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/8/17
 */
public class Solution {

    public boolean isValid(String s) {
        List<String> beginList = new ArrayList<>(), endList = new ArrayList<>();
        beginList.add("(");
        beginList.add("{");
        beginList.add("[");
        endList.add(")");
        endList.add("}");
        endList.add("]");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (beginList.indexOf(c) >= 0) {
                stack.push(c);
            } else {
                if (stack.empty() || beginList.indexOf(stack.pop()) != endList.indexOf(c)) {
                    System.out.println("wrong");
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("{}"));
        System.out.println(s.isValid("[]"));
        System.out.println(s.isValid("{}[]"));
        System.out.println(s.isValid("{("));
        System.out.println(s.isValid("{]("));
        System.out.println(s.isValid("]"));
    }
}

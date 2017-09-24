package traing.prob682;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Baseball Game
 * Link: https://leetcode.com/contest/leetcode-weekly-contest-51/problems/baseball-game/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/24/17
 */
public class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int last = stack.pop();
                int lasttwo = stack.pop();
                stack.push(lasttwo);
                stack.push(last);
                stack.push(last + lasttwo);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        while (!stack.isEmpty()) sum += stack.pop();
        return sum;
    }

}

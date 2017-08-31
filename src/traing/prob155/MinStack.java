package traing.prob155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Min Stack
 * Link: https://leetcode.com/problems/min-stack/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class MinStack {
    private Deque<Long> stack;
    private long min;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = 0;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Long pop = stack.pop();
        if (pop < 0) min -= pop;
    }

    public int top() {
        Long peek = stack.peek();
        if (peek > 0) {
            return (int) (peek + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}

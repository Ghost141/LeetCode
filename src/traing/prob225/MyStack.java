package traing.prob225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * Link: https://leetcode.com/problems/implement-stack-using-queues/tabs/description
 *
 * @author zhaokai
 */
public class MyStack {

    private Queue<Integer> queue;
    private int length;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        length++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int[] data = new int[length];
        int i = 0;
        while (!queue.isEmpty()) {
            data[i++] = queue.poll();
        }
        for (i = 0; i < length - 1; i++) {
            queue.add(data[i]);
        }
        return data[--length];
    }

    /** Get the top element. */
    public int top() {
        int[] data = new int[length];
        int i = 0;
        while (!queue.isEmpty()) {
            data[i++] = queue.poll();
        }
        for (i = 0; i < length; i++) {
            queue.add(data[i]);
        }
        return data[length - 1];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();

        s.push(1);
        s.push(2);

        System.out.println(s.pop());
    }
}

package traing.prob232;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/tabs/description
 *
 * @author zhaokai
 */
public class MyQueue {

    private Stack<Integer> stack;
    private int length;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
        this.length = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        this.length++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer[] tmpData = new Integer[this.length];
        int ind = 0;
        while (!stack.empty()) {
            tmpData[ind++] = stack.pop();
        }

        for (int i = tmpData.length - 2; i >= 0; i--) {
            stack.push(tmpData[i]);
        }

        this.length--;
        return tmpData[tmpData.length - 1];
    }

    /** Get the front element. */
    public int peek() {
        Integer[] tmpData = new Integer[this.length];
        int ind = 0;
        while (!stack.empty()) {
            tmpData[ind++] = stack.pop();
        }

        for (int i = tmpData.length - 1; i >= 0; i--) {
            stack.push(tmpData[i]);
        }

        return tmpData[tmpData.length - 1];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);

        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.empty());
    }
}

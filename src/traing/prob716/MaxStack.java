package traing.prob716;

import java.util.*;

/**
 * Max Stack
 * Link: https://leetcode.com/problems/max-stack/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/13/17
 */
public class MaxStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        maxHeap.offer(x);
    }

    public int pop() {
        Integer pop = stack.pop();
        List<Integer> tmpList = new ArrayList<>();
        while (!maxHeap.peek().equals(pop)) tmpList.add(maxHeap.poll());
        maxHeap.poll();
        maxHeap.addAll(tmpList);
        return pop;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxHeap.peek();
    }

    public int popMax() {
        Integer max = maxHeap.poll();
        List<Integer> tmpList = new ArrayList<>();
        while (!stack.peek().equals(max)) tmpList.add(stack.pop());
        stack.pop();
        for (int i = tmpList.size() - 1; i >= 0; i--) stack.push(tmpList.get(i));
        return max;
    }

    public static void main(String[] args) {
        MaxStack s = new MaxStack();


//        String[] command = new String[] {"push","push","peekMax","push","top","popMax","top","push","push","push","top","push","pop","peekMax","popMax","push","popMax","push","top","top","popMax","popMax","push","push","push","peekMax","pop","push","peekMax","push","popMax","push","peekMax","pop","top","peekMax","top","peekMax","popMax","pop","top","push","peekMax","push","top","push","push","pop","push","push","push","popMax","top","push","popMax","peekMax","peekMax","push","pop","push","popMax","push","push","popMax","peekMax","pop","push","peekMax","popMax","popMax","popMax","push","push","peekMax","peekMax","pop","pop","popMax","push","peekMax","pop","top","top","push","push","top","push","pop","push","peekMax","popMax","push","peekMax","top","top","popMax","push","push","push","popMax"};
//        int[][] value = new int[][] {
//                {-1919630},{7447491},{},{-2983652},{},{},{},{-3334898},{8846062},{2479120},{},{7050263},{},{},{},{-3743643},{},{-6196638},{},{},{},{},{-6436831},{-2835331},{3549770},{},{},{2643568},{},{-7853726},{},{-369996},{},{},{},{},{},{},{},{},{},{-9254475},{},{4462697},{},{7055993},{-4050360},{},{7162941},{-9620570},{6295114},{},{},{6366218},{},{},{},{-4009957},{},{4552628},{},{-7488568},{9893848},{},{},{},{1477827},{},{},{},{},{333068},{6486948},{},{},{},{},{},{-4255526},{},{},{},{},{-1598000},{-5135401},{},{-6279567},{},{-9375733},{},{},{-3078338},{},{},{},{},{8800414},{-4237017},{945773},{}
//        };
//        for (int i = 0; i < command.length; i++) {
//            int[] param = value[i];
//            System.out.println("s." + command[i] + "(" + (param.length == 0 ? "" : param[0]) + ");");
//        }
//        s.push(-1919630);
//        s.push(7447491);
//        s.peekMax();
//        s.push(-2983652);
//        s.top();
//        s.popMax();
//        s.top();
//        s.push(-3334898);
//        s.push(8846062);
//        s.push(2479120);
//        s.top();
//        s.push(7050263);
//        s.pop();
//        s.peekMax();
//        s.popMax();
//        s.push(-3743643);
//        s.popMax();
//        s.push(-6196638);
//        s.top();
//        s.top();
//        s.popMax();
//        s.popMax();
//        s.push(-6436831);
//        s.push(-2835331);
//        s.push(3549770);
//        s.peekMax();
//        s.pop();
//        s.push(2643568);
//        s.peekMax();
//        s.push(-7853726);
//        s.popMax();
//        s.push(-369996);
//        s.peekMax();
//        s.pop();
//        s.top();
//        s.peekMax();
//        s.top();
//        s.peekMax();
//        s.popMax();
//        s.pop();
//        s.top();
//        s.push(-9254475);
//        s.peekMax();
//        s.push(4462697);
//        s.top();
//        s.push(7055993);
//        s.push(-4050360);
//        s.pop();
//        s.push(7162941);
//        s.push(-9620570);
//        s.push(6295114);
//        s.popMax();
//        s.top();
//        s.push(6366218);
//        s.popMax();
//        s.peekMax();
//        s.peekMax();
//        s.push(-4009957);
//        s.pop();
//        s.push(4552628);
//        s.popMax();
//        s.push(-7488568);
//        s.push(9893848);
//        s.popMax();
//        s.peekMax();
//        s.pop();
//        s.push(1477827);
//        s.peekMax();
//        s.popMax();
//        s.popMax();
//        s.popMax();
//        s.push(333068);
//        s.push(6486948);
//        s.peekMax();
//        s.peekMax();
//        s.pop();
//        s.pop();
//        s.popMax();
//        s.push(-4255526);
//        s.peekMax();
//        s.pop();
//        s.top();
//        s.top();
//        s.push(-1598000);
//        s.push(-5135401);
//        s.top();
//        s.push(-6279567);
//        s.pop();
//        s.push(-9375733);
//        s.peekMax();
//        s.popMax();
//        s.push(-3078338);
//        s.peekMax();
//        s.top();
//        s.top();
//        s.popMax();
//        s.push(8800414);
//        s.push(-4237017);
//        s.push(945773);
//        s.popMax();

        s.push(92);
        s.push(54);
        s.push(22);
        s.pop();
        s.pop();
        s.push(-57);
        s.push(-24);
        System.out.println(s.popMax());
        System.out.println(s.top());
    }
}

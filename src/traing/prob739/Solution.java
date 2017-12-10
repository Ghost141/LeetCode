package traing.prob739;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Daily Temperatures
 * Link: https://leetcode.com/problems/daily-temperatures/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/3/17
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        if (N <= 1) return new int[N];
        int[] res = new int[N];
        int ind = res.length - 2;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N);
        stack.push(N - 1);
        for (int i = N - 2; i >= 0; i--) {
            while (stack.peek() != N) {
                if (temperatures[stack.peek()] <= temperatures[i]) stack.pop();
                else break;
            }
            if (stack.peek() == N) res[ind--] = 0;
            else res[ind--] = Math.abs(stack.peek() - i);
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.dailyTemperatures(DataGenerator.createIntArray("73, 74, 75, 71, 69, 72, 76, 73")));
    }
}

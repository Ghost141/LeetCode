package traing.prob239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum
 * Link: https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/22/17
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ind = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) queue.poll();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            queue.offer(i);
            if (i >= k - 1) res[ind++] = nums[queue.peek()];
        }
        return res;
    }
}

package traing.prob621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Task Scheduler
 * Link: https://leetcode.com/problems/task-scheduler/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/21/17
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        PriorityQueue<Integer> heap = new PriorityQueue<>(26, Collections.reverseOrder());
        int time = 0;
        for (char c : tasks) count[c - 'A']++;
        for (int c : count) if (c > 0) heap.offer(c);
        while (!heap.isEmpty()) {
            int cycle = 0;
            List<Integer> temp = new ArrayList<>();
            while (cycle <= n) {
                if (!heap.isEmpty()) {
                    if (heap.peek() > 1) temp.add(heap.poll() - 1);
                    else heap.poll();
                }
                time++;
                if (heap.isEmpty() && temp.isEmpty()) break;
                cycle++;
            }
            heap.addAll(temp);
        }
        return time;
    }
}

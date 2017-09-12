package traing.prob502;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * IPO
 * Link: https://leetcode.com/problems/ipo/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int projectCount = 0;
        final int CAPITAL = 0, PROFIT = 1;
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        PriorityQueue<int[]> profitQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        for (int i = 0; i < Capital.length; i++) {
            int[] pair = new int[] {Capital[i], Profits[i]};
            if (pair[CAPITAL] <= W) profitQueue.offer(pair);
            else capitalQueue.offer(pair);
        }

        while (projectCount != k && !profitQueue.isEmpty()) {
            int[] project = profitQueue.poll();
            W += project[PROFIT];
            while (!capitalQueue.isEmpty() && capitalQueue.peek()[CAPITAL] <= W)
                profitQueue.offer(capitalQueue.poll());
            projectCount++;
        }
        return W;
    }
}

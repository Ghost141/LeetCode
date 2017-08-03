package traing.prob264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Ugly Number II
 * Link: https://leetcode.com/problems/ugly-number-ii/description/
 *
 * @author zhaokai
 * @version 1.1
 * @since 1.0 - 8/3/17
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int count = 0, start = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> uglySet = new HashSet<>();
        priorityQueue.add(start);
        int uglyNumber = 0;
        while (count != n) {
            uglyNumber = priorityQueue.poll();
            updateQueue(uglySet, priorityQueue, uglyNumber);
            count++;
        }

        return uglyNumber;
    }
    private void updateQueue(Set<Integer> uglySet, PriorityQueue<Integer> uglyQueue, int ugly) {
        for (int i = 2; i < 6; i++) {
            int next = i * ugly;
            if (next > 0 && next > ugly) {
                if (!uglySet.contains(next)) {
                    uglyQueue.add(next);
                    uglySet.add(next);
                }
            } else break;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.nthUglyNumber(1));
//        System.out.println(s.nthUglyNumber(2));
//        System.out.println(s.nthUglyNumber(3));
//        System.out.println(s.nthUglyNumber(4));
        System.out.println(s.nthUglyNumber(5));
        System.out.println(s.nthUglyNumber(6));
        System.out.println(s.nthUglyNumber(7));
        System.out.println(s.nthUglyNumber(8));
        System.out.println(s.nthUglyNumber(9));
        System.out.println(s.nthUglyNumber(10));
        System.out.println(s.nthUglyNumber(1600));
//        System.out.println(s.nthUglyNumber(1601));
        System.out.println(1399680000);
        System.out.println(Integer.MAX_VALUE);
    }
}

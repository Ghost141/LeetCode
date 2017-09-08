package traing.prob253;

import traing.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Meeting Rooms II
 * Link: https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval inter = queue.poll();
            if (inter.end <= intervals[i].start) {
                inter.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }
            queue.offer(inter);
        }
        return queue.size();
    }
}

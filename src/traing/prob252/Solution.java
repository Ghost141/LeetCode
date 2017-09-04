package traing.prob252;

import traing.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Meeting Rooms
 * Link: https://leetcode.com/problems/meeting-rooms/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}

package mockinterview;

import traing.common.Interval;
import utils.DataGenerator;
import utils.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The mocking interview problem.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        int rooms = 1;
        Interval meeting = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < meeting.end) {
                rooms++;
                meeting.start = intervals[i].start;
                meeting.end = intervals[i].end;
            } else {
                meeting.end = Math.max(intervals[i].end, meeting.end);
            }
        }

        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII s = new MeetingRoomsII();

//        System.out.println(s.minMeetingRooms(DataGenerator.listInterval("9,10|4,9|4,17").toArray(new Interval[0])));
        System.out.println(s.minMeetingRooms(DataGenerator.listInterval("2,11|6,16|11,16").toArray(new Interval[0])));
    }
}

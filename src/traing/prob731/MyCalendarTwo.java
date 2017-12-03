package traing.prob731;

import java.util.ArrayList;
import java.util.List;

/**
 * My Calendar II
 * Link: https://leetcode.com/problems/my-calendar-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/19/17
 */
public class MyCalendarTwo {
    private List<Meeting> list = new ArrayList<>();
    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        List<Meeting> overlappingList = new ArrayList<>();
        for (Meeting meeting : list) {
            if (!(meeting.end <= start || meeting.start >= end)) {
                int s = Math.max(start, meeting.start), e = Math.min(end, meeting.end);

                for (Meeting overlap : overlappingList) {
                    if (!(overlap.end <= s || overlap.start >= e)) {
                        return false;
                    }
                }

                overlappingList.add(new Meeting(s, e));

            }
        }
        list.add(new Meeting(start, end));
        return true;
    }

    class Meeting{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo s = new MyCalendarTwo();

        System.out.println(s.book(10, 20));
        System.out.println(s.book(50, 60));
        System.out.println(s.book(10, 40));
        System.out.println(s.book(5, 15));
        System.out.println(s.book(5, 10));
        System.out.println(s.book(25, 55));
    }
}

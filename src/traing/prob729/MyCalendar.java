package traing.prob729;

import java.util.ArrayList;
import java.util.List;

/**
 * My Calendar I
 * Link: https://leetcode.com/problems/my-calendar-i/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/19/17
 */
public class MyCalendar {
    private List<Meeting> list = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (Meeting meeting : list) {
            if (!(meeting.end <= start || meeting.start >= end)) {
                return false;
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
        MyCalendar s = new MyCalendar();

        s.book(10, 20);
        s.book(15, 25);
        System.out.println(s.book(20, 30));
    }
}

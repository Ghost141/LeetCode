package traing.prob732;

import java.util.Map;
import java.util.TreeMap;

/**
 * My Calendar III
 * Link: https://leetcode.com/problems/my-calendar-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 12/11/17
 */
public class MyCalendarThree {
    private Map<Integer, Integer> tree = new TreeMap<>();
    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        tree.put(start, tree.getOrDefault(start, 0) + 1);
        tree.put(end, tree.getOrDefault(end, 0) - 1);
        int ongoing = 0, max = 0;
        for (Integer count : tree.values()) {
            max = Math.max(max, ongoing += count);
        }
        return max;
    }
}

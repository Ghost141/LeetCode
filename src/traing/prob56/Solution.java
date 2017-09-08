package traing.prob56;

import traing.common.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * Link: https://leetcode.com/problems/merge-intervals/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval inter : intervals) {
            if (inter.start <= end)
                end = Math.max(end, inter.end);
            else {
                res.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

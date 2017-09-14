package traing.prob57;

import traing.common.Interval;
import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval
 * Link: https://leetcode.com/problems/insert-interval/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval inter : intervals) {
            if (newInterval.end < inter.start) {
                res.add(new Interval(newInterval.start, newInterval.end));
                newInterval.start = inter.start;
                newInterval.end = inter.end;
            } else if (
                    (newInterval.start <= inter.start && newInterval.end >= inter.start)
                            || (newInterval.start >= inter.start && newInterval.end <= inter.end)
                            || (newInterval.start <= inter.end && newInterval.end >= inter.end)
                    ) {
                newInterval.start = Math.min(inter.start, newInterval.start);
                newInterval.end = Math.max(inter.end, newInterval.end);
            } else {
                res.add(inter);
            }
        }
        if (res.isEmpty() || (newInterval.end != res.get(res.size() - 1).end && newInterval.start != res.get(res.size() - 1).start))
            res.add(newInterval);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.insert(Arrays.asList(new Interval(1, 3), new Interval(6, 9)), new Interval(2, 5)));
        System.out.println(s.insert(DataGenerator.listInterval("1,2|3,5|6,7|8,10|12,16"), new Interval(4, 9)));
    }
}

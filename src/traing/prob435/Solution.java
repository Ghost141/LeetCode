package traing.prob435;

import traing.common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 * Link: https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/23/17
 */
public class Solution {
    private static final Comparator<Interval> START_COMPARATOR = Comparator.comparingInt(a -> a.start);
    private static final Comparator<Interval> END_COMPARATOR = Comparator.comparingInt(a -> a.end);
    public int eraseOverlapIntervals(Interval[] intervals) {
        return bruteForce(intervals);
    }

    private int bruteForce(Interval[] intervals) {
        Arrays.sort(intervals, START_COMPARATOR);
        return remove(intervals, -1, 0);
    }

    private int remove(Interval[] intervals, int prev, int cur) {
        if (cur == intervals.length) return 0;
        int notOverlap = 0;
        if (prev != -1 && intervals[cur].start >= intervals[prev].end) {
            notOverlap = remove(intervals, cur, cur + 1);
        }
        int overlap = remove(intervals, prev, cur + 1) + 1;

        return Math.min(overlap, notOverlap);
    }
}

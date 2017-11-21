package traing.prob436;

import traing.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Find Right Interval
 * Link: https://leetcode.com/problems/find-right-interval/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/21/17
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals.length == 0) return new int[0];
        Map<Interval, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) indexMap.put(intervals[i], i);
        int[] res = new int[intervals.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (Interval interval : intervals) {
            Interval inter = binarySearch(intervals, interval.end, 0, intervals.length - 1);
            res[indexMap.get(interval)] = inter == null ? -1 : indexMap.get(inter);
        }

        return res;
    }

    private Interval binarySearch(Interval[] intervals, int target, int start, int end) {
        if (start >= end) {
            if (intervals[start].start >= target) return intervals[start];
            else return null;
        } else {
            int mid = start + (end - start) / 2;
            if (intervals[mid].start > target) return binarySearch(intervals, target, start, mid);
            else return binarySearch(intervals, target, mid + 1, end);
        }
    }
}

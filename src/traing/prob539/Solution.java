package traing.prob539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Minimum Time Difference
 * Link: https://leetcode.com/problems/minimum-time-difference/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/12/17
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[1440];
        int start = Integer.MAX_VALUE, gap = Integer.MAX_VALUE, first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (String time : timePoints) {
            String[] split = time.split(":");
            int mins = 60 * Integer.valueOf(split[0]) + Integer.valueOf(split[1]);
            if (++minutes[mins] == 2) return 0;
        }
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i] > 0) {
                if (start == Integer.MAX_VALUE) {
                    start = i;
                } else {
                    int tmp = i - start < 1440 - i + start ? i - start : 1440 - i + start;
                    gap = Math.min(gap, tmp);
                    start = i;
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        return Math.min(gap, 1440 - last + first);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.findMinDifference(Arrays.asList("12:01","00:10","00:01")));
        System.out.println(s.findMinDifference(Arrays.asList("05:31", "22:08", "00:35")));
    }
}

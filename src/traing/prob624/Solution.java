package traing.prob624;

import java.util.List;

/**
 * Maximum Distance in Arrays
 * Link: https://leetcode.com/problems/maximum-distance-in-arrays/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE, minRow = 0
                , max = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE, maxRow = 0;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            Integer _min = list.get(0);
            Integer _max = list.get(list.size() - 1);
            if (_min < min) {
                secMin = min;
                min = _min;
                minRow = i;
            } else if (_min < secMin) {
                secMin = _min;
            }

            if (_max > max) {
                secMax = max;
                max = _max;
                maxRow = i;
            } else if (_max > secMax) {
                secMax = _max;
            }
        }
        if (minRow == maxRow) return Math.max(Math.abs(secMax - min), Math.abs(max - secMin));
        else return Math.abs(max - min);
    }
}

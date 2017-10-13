package traing.prob452;

import utils.DataGenerator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Minimum Number of Arrows to Burst Balloons
 * Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/13/17
 */
public class Solution {
    private static final int START = 0;
    private static final int END = 1;

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[END], o2[END]);
            }
        });
        int shot = points[0][END];
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][START] > shot) {
                count++;
                shot = points[i][END];
            }
        }

        if (points[points.length - 1][START] < shot) count++;
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMinArrowShots(DataGenerator.createIntMatrix("10,16|2,8|1,6|7,12")));
    }
}

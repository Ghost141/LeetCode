package traing.prob296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Best Meeting Point
 * Link: https://leetcode.com/problems/best-meeting-point/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/26/17
 */
public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
//        Collections.sort(rows); // No need to sort the row since we insert it in order.
        Collections.sort(cols);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);

        return calculate(rows, row) + calculate(cols, col);
    }
    private int calculate(List<Integer> points, int target) {
        int res = 0;
        for (Integer point : points) res += Math.abs(point - target);
        return res;
    }
}

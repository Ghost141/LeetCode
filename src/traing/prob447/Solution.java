package traing.prob447;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of Boomerangs
 * Link: https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] i : points) {
            for (int[] j : points) {
                int d = dis(i, j);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (Integer c : map.values()) {
                count += c * (c - 1);
            }
            map.clear();
        }
        return count;
    }
    private int dis(int[] a, int[] b) {
        int dx = a[0] - b[0], dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}

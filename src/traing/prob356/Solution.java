package traing.prob356;

import utils.DataGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * Line Reflection
 * Link: https://leetcode.com/problems/line-reflection/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            int x = point[0];
            min = Math.min(x, min);
            max = Math.max(x, max);
            pointSet.add(x + "#" + point[1]);
        }
        int sum = min + max;
        for (int[] point : points) {
            if (!pointSet.contains((sum - point[0]) + "#" + point[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isReflected(DataGenerator.createIntMatrix("1,1|-1,1")));
    }
}

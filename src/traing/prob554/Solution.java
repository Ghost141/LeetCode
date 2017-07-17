package traing.prob554;

import java.util.*;

/**
 * Brick Wall.
 *
 * @author zhaokai
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        int lines = wall.size();

        Map<Integer, Integer> map = new HashMap<>();
        int width = 0;

        for (List<Integer> line : wall) {
            int sum = 0;
            for (Integer brick : line) {
                sum += brick;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
            width = sum;
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() != width) {
                max = Math.max(entry.getValue(), max);
            }
        }
        return lines - max;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        List<Integer> l1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> l2 = Arrays.asList(3, 1, 2);
        List<Integer> l3 = Arrays.asList(1, 3, 2);
        List<Integer> l4 = Arrays.asList(2, 4);
        List<Integer> l5 = Arrays.asList(3, 1, 2);
        List<Integer> l6 = Arrays.asList(1, 3, 1, 1);

        List<List<Integer>> wall = Arrays.asList(l1, l2, l3, l4, l5, l6);

        System.out.println(s.leastBricks(wall));
    }
}

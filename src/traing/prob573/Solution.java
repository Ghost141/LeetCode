package traing.prob573;

import utils.DataGenerator;

/**
 * Squirrel Simulation
 * Link: https://leetcode.com/problems/squirrel-simulation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/13/17
 */
public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int distance = 0, saving = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            distance += dis(tree, nut) * 2;
            saving = Math.max(saving, dis(tree, nut) - dis(squirrel, nut));
        }

        return distance - saving;
    }

    private int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minDistance(3, 3, new int[] {0, 0}, new int[] {2, 2}, DataGenerator.createIntMatrix("1,0")));
    }
}

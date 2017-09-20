package traing.prob200;

import utils.DataGenerator;

/**
 * Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/20/17
 */
public class Solution {
    private int[][][] id;
    private int[][] size;
    private int count = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        this.count = grid.length * grid[0].length;
        int zeroCount = 0;
        id = new int[grid.length][grid[0].length][2];
        size = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') zeroCount++;
                else {
                    id[i][j][0] = i;
                    id[i][j][1] = j;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(new int[] {i, j}, new int[] {i - 1, j});
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(new int[] {i, j}, new int[] {i, j - 1});
                    }
                }
            }
        }

        return count - zeroCount;
    }

    private int[] find(int[] point) {
        int px = point[0];
        int py = point[1];
        while (px != id[px][py][0] || py != id[px][py][1]) {
            int oldx = px, oldy = py;
            px = id[oldx][oldy][0];
            py = id[oldx][oldy][1];
        }
        return new int[] {px, py};
    }

    private void union(int[] point1, int[] point2) {
        int[] root1 = find(point1);
        int[] root2 = find(point2);
        int x1 = root1[0];
        int y1 = root1[1];
        int x2 = root2[0];
        int y2 = root2[1];
        if (x1 == x2 && y1 == y2) return;

        if (size[x1][y1] < size[x2][y2]) {
            id[x1][y1][0] = x2;
            id[x1][y1][1] = y2;
            size[x2][y2] += size[x1][y1];
        } else {
            id[x2][y2][0] = x1;
            id[x2][y2][1] = y1;
            size[x1][y1] += size[x2][y2];
        }
        count--;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numIslands(DataGenerator.createCharBoard("11110|11010|11000|00000")));
    }
}

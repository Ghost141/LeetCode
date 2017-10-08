package traing.prob695;

import utils.DataGenerator;

/**
 * Max Area of Island
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/8/17
 */
public class Solution {
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private int[] root;
    private int[] size;
    private int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        root = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : DIRECTIONS) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                            union(i * n + j, x * n + y);
                        }
                    }
                    max = Math.max(size[i * n + j], max);
                }
            }
        }
        return max;
    }
    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            root[i] = root[j];
            size[j] += size[i];
        } else {
            root[j] = root[i];
            size[i] += size[j];
        }
        max = Math.max(Math.max(size[i], size[j]), max);
    }

    private int find(int p) {
        while (p != root[p]) p = root[p];
        return p;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxAreaOfIsland(new int[][] {{1}}));
    }
}

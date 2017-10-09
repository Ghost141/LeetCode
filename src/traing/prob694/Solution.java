package traing.prob694;

import utils.DataGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * Number of Distinct Islands
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/8/17
 */
public class Solution {
    private Set<Integer> shape;

    public int numDistinctIslands(int[][] grid) {
        Set<Set<Integer>> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    shape = new HashSet<>();
                    dfs(grid, visited, i, j, i, j);
                    if (!shape.isEmpty()) set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col, int rowZero, int colZero) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            shape.add((row - rowZero) * grid[0].length + (col - colZero));
            dfs(grid, visited, row + 1, col, rowZero, colZero);
            dfs(grid, visited, row, col + 1, rowZero, colZero);
            dfs(grid, visited, row - 1, col, rowZero, colZero);
            dfs(grid, visited, row, col - 1, rowZero, colZero);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.numDistinctIslands(DataGenerator.createIntMatrix("1,1,0,1,1|1,0,0,0,0|0,0,0,0,1|1,1,0,1,1")));
//        System.out.println(s.numDistinctIslands(new int[][]{{0, 1}}));
//        System.out.println(s.numDistinctIslands(DataGenerator.createIntMatrix("0,0,1|1,1,1")));
        System.out.println(s.numDistinctIslands(DataGenerator.createIntMatrix("0,1,0|1,0,1")));
    }
}

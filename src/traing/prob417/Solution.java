package traing.prob417;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Pacific Atlantic Water Flow
 * Link: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/11/17
 */
public class Solution {
    private static final int PACIFIC = 0;
    private static final int ATLANTIC = 1;
    private static final int[][] DIRECTIONS = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        boolean[] reached = new boolean[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[] point = {i, j};
                if (dfs(point, matrix, new boolean[matrix.length][matrix[i].length], reached))
                    res.add(point);
                reached[PACIFIC] = reached[ATLANTIC] = false;
            }
        }
        return res;
    }

    private boolean dfs(int[] point, int[][] matrix, boolean[][] visited, boolean[] reached) {
        int p0 = point[0];
        int p1 = point[1];
        if (p0 == 0 || p1 == 0) reached[PACIFIC] = true;
        if (p0 == matrix.length - 1 || p1 == matrix[0].length - 1) reached[ATLANTIC] = true;
        if (reached[PACIFIC] && reached[ATLANTIC]) return true;
        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + p0;
            int y = dir[1] + p1;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && !visited[x][y]
                    && matrix[x][y] <= matrix[p0][p1]) {
                visited[x][y] = true;
                if (dfs(new int[]{x, y}, matrix, visited, reached)) return true;
                visited[x][y] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<int[]> res = s.pacificAtlantic(DataGenerator.createIntMatrix("1,2,2,3,5|3,2,3,4,4|2,4,5,3,1|6,7,1,4,5|5,1,1,2,4"));
        res.forEach(PrintUtils::printai);
    }
}

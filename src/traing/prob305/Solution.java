package traing.prob305;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Number of Islands II
 * Link: https://leetcode.com/problems/number-of-islands-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/26/17
 */
public class Solution {
    private int count = 0;
    private final static int[][] DIR = new int[][] {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] id = new int[m * n];
        List<Integer> res = new ArrayList<>();

        Arrays.fill(id, -1);

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int root = transform(pos, n);

            id[root] = root;
            count++;
            for (int[] dir : DIR) {
                int x = dir[0] + row;
                int y = dir[1] + col;
                int neighbor = transform(new int[] {dir[0] + row, dir[1] + col}, n);
                if (x >= 0 && x < m && y >= 0 && y < n && id[neighbor] != -1) {
                    int neighborRoot = find(neighbor, id);
                    if (root != neighborRoot) {
                        id[root] = neighborRoot;
                        root = neighborRoot;
                        count--;
                    }
                }
            }

            res.add(count);
        }

        return res;
    }

    private int transform(int[] point, int colSize) {
        return colSize * point[0] + point[1];
    }

    private int find(int point, int[] id) {
        while (point != id[point]) {
            id[point] = id[id[point]];
            point = id[point];
        }
        return point;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numIslands2(3, 3, DataGenerator.createIntMatrix("0,1|1,2|2,1|1,0|0,2|0,0|1,1")));
    }
}

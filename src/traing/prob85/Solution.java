package traing.prob85;

import utils.DataGenerator;

import java.util.Arrays;

/**
 * Maximal Rectangle
 * Link: https://leetcode.com/problems/maximal-rectangle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/8/17
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[] leftBound = new int[n], rightBound = new int[n], height = new int[n];
        Arrays.fill(rightBound, n);
        int max = 0;

        for (char[] row : matrix) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                // Height
                if (row[j] == '1') height[j]++;
                else height[j] = 0;

                // Left
                if (row[j] == '1') leftBound[j] = Math.max(leftBound[j], curLeft);
                else {
                    curLeft = j + 1;
                    leftBound[j] = 0;
                }

                // Right
                if (row[n - j - 1] == '1') rightBound[n - j - 1] = Math.min(rightBound[n - j - 1], curRight);
                else {
                    curRight = n - j - 1;
                    rightBound[n - j - 1] = n;
                }
            }
            for (int j = 0; j < n; j++)
                max = Math.max((rightBound[j] - leftBound[j]) * height[j], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(DataGenerator.createCharBoard("10100|10111|11111|10010")));
    }
}

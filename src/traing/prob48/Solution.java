package traing.prob48;

/**
 * Rotate Image
 * Link: https://leetcode.com/problems/rotate-image/description/
 *
 * A very good discuss about rotate matrix: https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image?page=1
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/29/17
 */
public class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void reverse(int[][] matrix) {
        int up = 0, down = matrix.length - 1, tmp;
        while (up < down) {
            int[] upRow = matrix[up];
            int[] downRow = matrix[down];
            for (int i = 0; i < upRow.length; i++) {
                tmp = upRow[i];
                upRow[i] = downRow[i];
                downRow[i] = tmp;
            }
            up++;
            down--;
        }
    }

    private void swap(int[][] matrix, int ax, int ay, int bx, int by) {
        int tmp = matrix[ax][ay];
        matrix[ax][ay] = matrix[bx][by];
        matrix[bx][by] = tmp;
    }


}

package traing.prob378;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.PriorityQueue;

/**
 * Kth Smallest Element in a Sorted Matrix
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - The binary search version.
 * @since 1.0 - 10/9/17
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> heap = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) heap.offer(new Element(0, i, matrix[0][i]));
        for (int i = 0; i < k - 1; i++) {
            Element ele = heap.poll();
            if (ele.row + 1 < matrix.length)
                heap.offer(new Element(ele.row + 1, ele.col, matrix[ele.row + 1][ele.col]));
        }
        return heap.poll().val;
    }

    class Element implements Comparable<Element> {
        int row, col, val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.val, o.val);
        }
    }

    private int binarySearch(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
        while (low < high) {
            int j = matrix.length - 1, count = 0;
            int mid = low + (high - low) / 2;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count > k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] matrix = DataGenerator.createIntMatrix("1,3,5|6,7,12|11,14,14");
        PrintUtils.printIntMatrix(matrix);
        System.out.println(s.kthSmallest(matrix, 8));
    }
}

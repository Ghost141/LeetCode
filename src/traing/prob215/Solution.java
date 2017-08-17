package traing.prob215;

import utils.DataGenerator;

/**
 * Kth Largest Element in an Array
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int select(int[] data, int start, int end, int position) {
        int i = start, j = end;
        int pivot = data[end];
        while (i < j) {
            if (data[i] > pivot) {
                swap(data, i, --j);
            } else i++;
        }
        swap(data, i, end);
        int m = i - start + 1;

        if (m == position) {
            return data[i];
        } else if (m > position) {
            return select(data, start, i - 1, position);
        } else {
            return select(data, i + 1, end, position - m);
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findKthLargest(DataGenerator.createIntArray("99,99"), 1));
    }
}

package algorithm.sort;

import traing.Utils;

/**
 * The bubble sort algorithm implementation.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/16/17
 */
public class BubbleSort implements IntArraySort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    SortUtils.swap(data, j, j + 1);
                }
            }
        }

        return data;
    }

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();

        Utils.printai(s.sort(new int[]{2, 3, 4, 1, 5, 2}));
        Utils.printai(s.sort(new int[]{5, 4, 3, 2, 1, 0}));
    }
}

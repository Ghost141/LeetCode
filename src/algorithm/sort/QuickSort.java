package algorithm.sort;

import java.util.Random;

/**
 * Quick Sort implementation
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/16/17
 */
public class QuickSort extends BaseSort {

    private Random random = new Random();

    @Override
    public void sort(Comparable[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(Comparable[] data, int low, int high) {
        if (high <= low) return;

        int j = partition(data, low, high);

        sort(data, low, j - 1);
        sort(data, j + 1, high);
    }

    private int partition(Comparable[] data, int low, int high) {
        int i = low, j = high + 1;
        Comparable pivot = data[low];
        while (true) {
            while (isLess(data[++i], pivot)) if (i == high) break;
            while (isLess(pivot, data[--j])) if (j == low) break;
            if (i >= j) break;
            swap(data, i, j);
        }
        swap(data, low, j);
        return j;
    }
}

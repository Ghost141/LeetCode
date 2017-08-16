package algorithm.sort;

/**
 * Insertion Sort implementation.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class InsertionSort implements IntArraySort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && data[j] < data[j - 1]; j--) {
                SortUtils.swap(data, j, j - 1);
            }
        }
        return new int[0];
    }
}

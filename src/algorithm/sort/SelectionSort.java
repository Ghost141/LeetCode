package algorithm.sort;

/**
 * Implementation of selection sort.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class SelectionSort implements IntArraySort {
    @Override
    public int[] sort(int[] data) {
        int n = data.length;

        for (int i = 0; i < n; i++) {
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (data[minInd] > data[j]) minInd = j;
            }
            SortUtils.swap(data, i, minInd);
        }
        return data;
    }
}

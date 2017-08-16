package algorithm.sort;

/**
 * Merge sort.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/16/17
 */
public class MergeSort extends BaseSort {
    private Comparable[] tmpData;

    @Override
    public void sort(Comparable[] data) {
        tmpData = new Comparable[data.length];
        sort(data, 0, data.length - 1);
    }

    private void sort(Comparable[] data, int low, int high) {
        if (low <= high) return;
        int middle = (low + high) / 2;

        sort(data, low, middle);
        sort(data, middle + 1, high);
        merge(data, low, middle, high);
    }

    private void merge(Comparable[] data, int low, int middle, int high) {
        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++)
            tmpData[k] = data[k];
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                data[k] = tmpData[j++];
            } else if (j > high) {
                data[k] = tmpData[i++];
            } else if (isLess(tmpData[j], tmpData[i])) {
                data[k] = tmpData[j++];
            } else {
                data[k] = tmpData[i++];
            }
        }
    }
}

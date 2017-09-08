package algorithm.sort;

import utils.PrintUtils;
import utils.DataGenerator;

import static algorithm.sort.SortUtils.swap;

/**
 * The quick select algorithm implementation.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/16/17
 */
public class QuickSelect {
    public int select(int[] data, int kth) {
        return _select(data, 0, data.length - 1, kth);
    }
    private int _select(int[] data, int start, int end, int kth) {
        int pivotIndex = end;
        int sortedIndex = partition(data, start, end);
        if (sortedIndex == kth - 1) {
            return data[sortedIndex];
        } else if (sortedIndex > kth - 1) {
            return _select(data, start, pivotIndex - 1, kth);
        } else {
            return _select(data, pivotIndex + 1, end, kth);
        }
    }

    public int partition(int[] data, int start, int end) {
        int i = start, j = end;
        int pivot = data[end];
        while (i < j) {
            if (data[i] > pivot) {
                swap(data, i, --j);
            } else {
                i++;
            }
        }
        swap(data, i, end);
        return i;
    }

    int quickSelect(int[] a, int lo, int hi, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if (m == k)     return i;
            // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k);
            // pivot is too small, so it must be on the right
        else            return quickSelect(a, i + 1, hi, k - m);
    }

    public static void main(String[] args) {
        QuickSelect sel = new QuickSelect();

        int[] data = DataGenerator.createIntArray("5,1,4,3,2,1,7,3");
        System.out.println(sel.partition(data, 0, data.length - 1));
        PrintUtils.printai(data);
        System.out.println(sel.select(DataGenerator.createIntArray("5,1,4,3,2,1,7,3"), 2));
    }
}

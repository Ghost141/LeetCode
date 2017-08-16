package algorithm.sort;

/**
 * Shell Sort
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class ShellSort extends BaseSort {

    @Override
    public void sort(Comparable[] data) {
        int n = data.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && isLess(data[j], data[j - h]); j -= h)
                    swap(data, j, j - h);
            }
            h /= 3;
        }
    }
}

package algorithm.sort;

/**
 * Base sort class
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public abstract class BaseSort {
    abstract public void sort(Comparable[] data);

    public boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void swap(Comparable[] data, int i, int j) {
        if (i == j) return;
        Comparable tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

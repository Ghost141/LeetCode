package algorithm.sort;

/**
 * Sort utils.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/16/17
 */
public class SortUtils {
    private static SortUtils ourInstance = new SortUtils();

    public static SortUtils getInstance() {
        return ourInstance;
    }

    private SortUtils() {}

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

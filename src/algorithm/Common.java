package algorithm;

/**
 * Some basic method for other algorithm.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/27/17
 */
public class Common {
    public static long factorial(int n) {
        long res = 1;
        while (n != 0) res *= n--;
        return res;
    }
}

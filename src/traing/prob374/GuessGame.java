package traing.prob374;

/**
 * Mock GuessGame
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class GuessGame {
    protected int val;

    protected int guess(int num) {
        return Integer.compare(val, num);
    }
}

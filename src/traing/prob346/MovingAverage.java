package traing.prob346;

/**
 * Moving Average from Data Stream
 * Link: https://leetcode.com/problems/moving-average-from-data-stream/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/7/17
 */
public class MovingAverage {
    private int count = 0;
    private int size = 0;
    private long sum = 0;
    private int[] data;
    private int next = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        data = new int[size];
    }

    public double next(int val) {
        sum -= data[next % size];
        data[next % size] = val;
        next++;
        sum += val;
        count = (count + 1) > size ? size : count + 1;
        return (double) sum / count;
    }
}

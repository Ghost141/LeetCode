package traing.prob362;

/**
 * Design Hit Counter
 * Link: https://leetcode.com/problems/design-hit-counter/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Using buckets to record data.
 * @since 1.0 - 8/22/17
 */
public class HitCounter {
    private int[] times;
    private int[] hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        this.times = new int[300];
        this.hits = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int ind = timestamp % 300;
        if (this.times[ind] != timestamp) {
            this.times[ind] = timestamp;
            this.hits[ind] = 1;
        } else this.hits[ind]++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++)
        {
            if (timestamp - this.times[i] < 300) {
                res += this.hits[i];
            }
        }
        return res;
    }
}

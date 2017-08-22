package traing.prob362;

import java.util.HashMap;
import java.util.Map;

/**
 * Design Hit Counter
 * Link: https://leetcode.com/problems/design-hit-counter/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class HitCounter {
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        this.map = new HashMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++)
            if (map.containsKey(timestamp - i)) res += map.get(timestamp - i);
        return res;
    }
}

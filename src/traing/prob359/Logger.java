package traing.prob359;

import java.util.HashMap;
import java.util.Map;

/**
 * Logger Rate Limiter
 * Link: https://leetcode.com/problems/logger-rate-limiter/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Logger {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < map.getOrDefault(message, 0)) {
            return false;
        }
        map.put(message, timestamp + 10);
        return true;
    }
}

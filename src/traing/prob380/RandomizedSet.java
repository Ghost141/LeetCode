package traing.prob380;

import java.util.*;

/**
 * Insert Delete GetRandom O(1)
 * Link: https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class RandomizedSet {
    private List<Integer> data;
    private Map<Integer, Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.data = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) return false;
        this.data.add(val);
        this.map.put(val, data.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) return false;
        Integer location = map.get(val);
        if (location != data.size() - 1) {
            Integer last = data.get(data.size() - 1);
            data.set(location, last);
            map.put(last, location);
        }

        map.remove(val);
        data.remove(data.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

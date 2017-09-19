package traing.prob170;

import java.util.*;

/**
 * Two Sum III - Data structure design
 * Link: https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public TwoSum() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer key : map.keySet())
            if ((value - key == key && map.get(key) >= 2) || (value - key != key && map.containsKey(value - key)))
                return true;
        return false;
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();

        s.add(0);
        s.add(-1);
        s.add(1);
        System.out.println(s.find(0));
    }
}

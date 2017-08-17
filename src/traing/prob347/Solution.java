package traing.prob347;

import utils.DataGenerator;

import java.util.*;

/**
 * Top K Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Counter> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Counter counter = map.get(num);
                counter.count++;
                map.put(num, counter);
            } else {
                Counter counter = new Counter(num, 1);
                map.put(num, counter);
            }
        }
        PriorityQueue<Counter> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Counter> entry : map.entrySet()) {
            queue.add(entry.getValue());
        }
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(queue.poll().val);
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.topKFrequent(DataGenerator.createIntArray("1,1,1,2,2,3"), 2));
    }

}
class Counter implements Comparable<Counter> {
    int val;
    int count = 0;

    public Counter(int val, int count) {
        this.val = val;
        this.count = count;
    }

    @Override
    public int compareTo(Counter o) {
        return -Integer.compare(this.count, o.count);
    }
}
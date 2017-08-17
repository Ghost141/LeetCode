package traing.prob347;

import utils.DataGenerator;

import java.util.*;

/**
 * Top K Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Bucket sort solution.
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        return res.subList(0, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.topKFrequent(DataGenerator.createIntArray("1,1,1,2,2,3"), 2));
    }

}

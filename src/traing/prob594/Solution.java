package traing.prob594;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Harmonious Subsequence
 * Link: https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1))
                len = Math.max(map.get(entry.getKey() + 1) + entry.getValue(), len);
            else if (map.containsKey(entry.getKey() - 1))
                len = Math.max(map.get(entry.getKey() - 1) + entry.getValue(), len);
        }
        return len;
    }
}

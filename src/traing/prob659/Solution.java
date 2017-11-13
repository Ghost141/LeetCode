package traing.prob659;

import java.util.HashMap;
import java.util.Map;

/**
 * Split Array into Consecutive Subsequences
 * Link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/13/17
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(), subMap = new HashMap<>();
        for (int num : nums) frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            if (frequencyMap.get(num) == 0) continue;
            else if (subMap.getOrDefault(num, 0) > 0) {
                subMap.put(num, subMap.get(num) - 1);
                subMap.put(num + 1, subMap.getOrDefault(num + 1, 0) + 1);
            } else if (frequencyMap.getOrDefault(num + 1, 0) > 0
                    && frequencyMap.getOrDefault(num + 2, 0) > 0) {
                frequencyMap.put(num + 1, frequencyMap.get(num + 1) - 1);
                frequencyMap.put(num + 2, frequencyMap.get(num + 2) - 1);
                subMap.put(num + 3, subMap.getOrDefault(num + 3, 0) + 1);
            } else return false;
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }
        return true;
    }
}

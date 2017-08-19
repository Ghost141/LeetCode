package traing.prob525;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 * Link: https://leetcode.com/problems/contiguous-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/19/17
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }
}

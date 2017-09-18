package traing.prob128;

import utils.DataGenerator;

import java.util.*;

/**
 * Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int totalLen = left + right + 1;
                max = Math.max(max, totalLen);

                map.put(num, totalLen);
                map.put(num - left, totalLen);
                map.put(num + right, totalLen);
            }
        }
        System.out.println(map);
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(DataGenerator.createIntArray("1,2,3,4,5")));
    }
}

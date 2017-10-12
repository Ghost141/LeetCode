package traing.prob496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I
 * Link: https://leetcode.com/problems/next-greater-element-i/description/
 *
 * @author zhaokai
 * @version 1.0 - Failed to implement.
 * @since 1.0 - 6/20/17
 */
public class Solution {
    /**
     * Failed implementation. I failed to understand problem description.
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        Map<Integer, Integer> greaterMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                // The last one. also the max one.

            }
            greaterMap.put(nums[i], i == length - 1 ? -1 : nums[i + 1]);
        }

        final int findLength = findNums.length;
        int[] result = new int[findLength];

        for (int i = 0; i < findLength; i++) {
            result[i] = greaterMap.get(findNums[i]);
        }

        return result;
    }
}

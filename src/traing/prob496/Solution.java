package traing.prob496;

import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I
 * Link: https://leetcode.com/problems/next-greater-element-i/description/
 *
 * @author zhaokai
 * @version 1.0 - Failed to implement.
 * @version 1.1 - Better brute force solution by using Hash Table.
 * @since 1.0 - 6/20/17
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < findNums.length; i++) {
            int ind = -1;
            for (int j = map.get(findNums[i]) + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    ind = j;
                    break;
                }
            }
            res[i] = ind == -1 ? -1 : nums[ind];
        }

        return res;
    }
}

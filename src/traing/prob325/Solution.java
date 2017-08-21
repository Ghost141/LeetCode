package traing.prob325;

import utils.DataGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximum Size Subarray Sum Equals k
 * Link: https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/19/17
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxSubArrayLen(DataGenerator.createIntArray("1,1,0"), 1));
    }
}

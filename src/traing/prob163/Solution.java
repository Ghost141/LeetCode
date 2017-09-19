package traing.prob163;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Missing Ranges
 * Link: https://leetcode.com/problems/missing-ranges/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) res.add(String.valueOf(lower));
            else res.add(lower + "->" + upper);
            return res;
        }
        long left = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left) continue;
            if (left == nums[i]) {
                left++;
                continue;
            }
            if (left == nums[i] - 1) res.add(String.valueOf(left));
            else res.add(left + "->" + (nums[i] - 1));

            left = (long) nums[i] + 1;
        }
        if (left <= upper) {
            if (nums[nums.length - 1] + 1 == upper) res.add(String.valueOf(upper));
            else res.add((nums[nums.length - 1] + 1) + "->" + upper);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMissingRanges(new int[] {Integer.MAX_VALUE}, 0, Integer.MAX_VALUE));
    }
}

package traing.prob15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * Link: https://leetcode.com/problems/3sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1, end = nums.length - 1, target = 0 - nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++; end--;
                    } else if (nums[start] + nums[end] > target) end--;
                    else start++;
                }
            }
        }
        return res;
    }
}

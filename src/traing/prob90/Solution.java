package traing.prob90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II
 * Link: https://leetcode.com/problems/subsets-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/15/17
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        build(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void build(List<List<Integer>> res, List<Integer> list, int start, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            build(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}

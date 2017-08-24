package traing.prob491;

import utils.DataGenerator;

import java.util.*;

/**
 * Increasing Subsequences
 * Link: https://leetcode.com/problems/increasing-subsequences/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        find(res, new ArrayList<>(), nums, 0);
        return new ArrayList<>(res);
    }

    private void find(Set<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
        if (tmp.size() >= 2) list.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                find(list, tmp, nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findSubsequences(DataGenerator.createIntArray("4,6,7,7")));
    }
}

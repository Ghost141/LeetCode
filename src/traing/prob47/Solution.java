package traing.prob47;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations II
 * Link: https://leetcode.com/problems/permutations-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) list.add(new ArrayList<>(tmp));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) continue;
                tmp.add(nums[i]);
                used[i] = true;
                backtrack(list, tmp, nums, used);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.permuteUnique(DataGenerator.createIntArray("1,1,2")));
    }
}

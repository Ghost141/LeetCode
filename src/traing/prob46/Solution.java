package traing.prob46;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * Link: https://leetcode.com/problems/permutations/description/
 *
 * A good discuss here: https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackPermutation(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrackPermutation(List<List<Integer>> list, List<Integer> perm, int[] nums) {
        if (perm.size() == nums.length) list.add(new ArrayList<>(perm));
        else {
            for (int i = 1; i <= nums.length; i++) {
                if (perm.contains(i)) continue;
                perm.add(i);
                backtrackPermutation(list, perm, nums);
                perm.remove(perm.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.permute(DataGenerator.createIntArray("1,2,3")));
    }
}

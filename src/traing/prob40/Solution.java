package traing.prob40;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 * Link: https://leetcode.com/problems/combination-sum-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tmp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                tmp.add(candidates[i]);
                backtrack(list, tmp, candidates, remain - candidates[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum2(DataGenerator.createIntArray("10,1,2,7,6,1,5"), 8));
    }
}

package traing.prob39;

import utils.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * Link: https://leetcode.com/problems/combination-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        calculate(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void calculate(List<List<Integer>> list, List<Integer> tmp, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tmp));
        else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                calculate(list, tmp, candidates, remain - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum(DataGenerator.createIntArray("2,3,6,7"), 7));
    }
}

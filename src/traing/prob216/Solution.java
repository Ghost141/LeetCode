package traing.prob216;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * Link: https://leetcode.com/problems/combination-sum-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] can = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), can, n, k);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] can, int n, int k) {
        if (n < 0 || tmp.size() == k && n != 0) return;
        else if (tmp.size() == k && n == 0) list.add(new ArrayList<>(tmp));
        else {
            for (int i = tmp.size() == 0 ? 0 : tmp.get(tmp.size() - 1); i < can.length; i++) {
                tmp.add(can[i]);
                backtrack(list, tmp, can, n - can[i], k);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9));
    }
}

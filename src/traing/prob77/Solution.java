package traing.prob77;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * Link: https://leetcode.com/problems/combinations/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        build(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void build(List<List<Integer>> res, List<Integer> set, int start, int n, int k) {
        if (set.size() == k) res.add(new ArrayList<>(set));
        else {
            for (int i = start; i <= n; i++) {
                set.add(i);
                build(res, set, i + 1, n, k);
                set.remove(set.size() - 1);
            }
        }
    }

}

package traing.prob254;

import java.util.ArrayList;
import java.util.List;

/**
 * Factor Combinations
 * Link: https://leetcode.com/problems/factor-combinations/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        _get(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void _get(List<List<Integer>> list, List<Integer> tmp, int n, int start) {
        if (n <= 1) {
            if (tmp.size() > 1) list.add(new ArrayList<>(tmp));
            return;
        } else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    tmp.add(i);
                    _get(list, tmp, n / i, i);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}

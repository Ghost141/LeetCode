package traing.prob386;

import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographical Numbers
 * Link: https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            res.add(num);
            if (num * 10 <= n) num *= 10;
            else if (num % 10 != 9 && num + 1 <= n) num++;
            else {
                while ((num / 10) % 10 == 9) {
                    num /= 10;
                }
                num = num / 10 + 1;
            }
        }
        return res;
    }

    private List<Integer> dfsSolution(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            _dfs(res, i, n);
        }
        return res;
    }

    private void _dfs(List<Integer> list, int cur, int n) {
        if (cur > n) return;
        else {
            list.add(cur);
            for (int i = 0; i < 10; i++) {
                if (cur * 10 + i > n) return;
                else _dfs(list, cur * 10 + i, n);
            }
        }
    }
}

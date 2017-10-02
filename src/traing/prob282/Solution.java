package traing.prob282;

import java.util.ArrayList;
import java.util.List;

/**
 * Expression And Operators
 * Link: https://leetcode.com/problems/expression-add-operators/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(num.toCharArray(), 0, target, 0, 0, "", res);
        return res;
    }

    private void backtrack(char[] num, int start, long target, long eval, long multed, String path, List<String> res) {
        if (start == num.length) {
            if (target == eval) res.add(path);
        } else {
            long val = 0;
            for (int i = start; i < num.length; i++) {
                val = val * 10 + (num[i] - '0');
                if (i != start && num[start] == '0') break;
                if (start == 0) {
                    backtrack(num, i + 1, target, val, val, path + val, res);
                } else {
                    backtrack(num, i + 1, target, eval + val, val, path + '+' + val, res);
                    backtrack(num, i + 1, target, eval - val, -val, path + '-' + val, res);
                    backtrack(num, i + 1, target, eval - multed + multed * val, multed * val, path + '*' + val, res);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.addOperators("123", 6));
//        System.out.println(s.addOperators("232", 8));
        System.out.println(s.addOperators("105", 5));
    }
}

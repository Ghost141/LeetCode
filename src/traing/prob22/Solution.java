package traing.prob22;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * Link: https://leetcode.com/problems/generate-parentheses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(res, "", n, 0, 0);
        return res;
    }

    private void gen(List<String> list, String s, int n, int leftCount, int rightCount) {
        if (s.length() == 2 * n) list.add(s);
        else {
            if (leftCount < n) gen(list, s + "(", n, leftCount + 1, rightCount);
            if (rightCount < leftCount) gen(list, s + ")", n, leftCount, rightCount + 1);
        }
    }
}

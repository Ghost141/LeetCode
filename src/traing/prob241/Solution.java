package traing.prob241;

import java.util.ArrayList;
import java.util.List;

/**
 * Different Ways to Add Parentheses
 * Link: https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/22/17
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '*' || c == '+') {
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer num1 : res1) {
                    for (Integer num2 : res2) {
                        if (c == '-') res.add(num1 - num2);
                        else if (c == '+') res.add(num1 + num2);
                        else res.add(num1 * num2);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}

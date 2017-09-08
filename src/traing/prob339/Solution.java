package traing.prob339;

import traing.common.NestedInteger;

import java.util.List;

/**
 * Nested List Weight Sum
 * Link: https://leetcode.com/problems/nested-list-weight-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }

    private int sum(List<NestedInteger> list, int weight) {
        int result = 0;
        for (NestedInteger in : list) {
            if (in.isInteger()) {
                result += in.getInteger() * weight;
            } else {
                result += sum(in.getList(), weight + 1);
            }
        }
        return result;
    }
}

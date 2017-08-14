package traing.prob364;

import traing.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Nested List Weight Sum II
 * Link: https://leetcode.com/problems/nested-list-weight-sum-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<NestedInteger> nested = nestedList;
        int unweigeted = 0, weighted = 0;
        while (!nested.isEmpty()) {
            List<NestedInteger> tmp = new ArrayList<>();
            for (NestedInteger in : nested) {
                if (in.isInteger()) {
                    unweigeted += in.getInteger();
                } else {
                    tmp.addAll(in.getList());
                }
            }
            nested = tmp;
            weighted += unweigeted;
        }

        return weighted;
    }
}

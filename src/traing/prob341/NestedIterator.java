package traing.prob341;

import traing.common.NestedInteger;

import java.util.*;

/**
 * Flatten Nested List Iterator
 * Link: https://leetcode.com/problems/flatten-nested-list-iterator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class NestedIterator implements Iterator<Integer> {

    private Deque<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.peek().next().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            ListIterator<NestedInteger> peek = stack.peek();
            if (!peek.hasNext()) {
                stack.pop();
            } else {
                NestedInteger x = peek.next();
                if (x.isInteger()) {
                    return peek.previous() == x;
                }
                stack.push(x.getList().listIterator());
            }
        }
        return false;
    }
}
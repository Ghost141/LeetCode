package traing.prob284;

import java.util.Iterator;

/**
 * Peeking Iterator
 * Link: https://leetcode.com/problems/peeking-iterator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/3/17
 */
public class PeekingIterator implements Iterator<Integer> {
    Integer peek = null;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            peek = this.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result;
        if (peek != null) {
            result = peek;
            peek = null;
        } else {
            result = iterator.next();
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return peek != null || iterator.hasNext();
    }
}

package traing.prob281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Zigzag Iterator
 * Link: https://leetcode.com/problems/zigzag-iterator/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class ZigzagIterator {
    private List<ListIterator<Integer>> iterators = new ArrayList<>();
    private int cursor = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.iterators.add(v1.listIterator());
        this.iterators.add(v2.listIterator());
    }

    public ZigzagIterator(List<Integer> v1, List<Integer> v2, List<Integer> v3) {
        this.iterators.add(v1.listIterator());
        this.iterators.add(v2.listIterator());
        this.iterators.add(v3.listIterator());
    }

    public int next() {
        hasNext();
        Integer res = this.iterators.get(cursor).next();
        cursor = (cursor + 1) % iterators.size();
        return res;
    }

    public boolean hasNext() {
        ListIterator<Integer> it = iterators.get(cursor);
        int n = iterators.size();
        int i = 0;
        for (; i < n; i++) {
            if (this.iterators.get((cursor + i) % n).hasNext()) {
                break;
            }
        }
        cursor = (cursor + i) % n;
        return this.iterators.get(cursor).hasNext();
    }

    public static void main(String[] args) {
        ZigzagIterator i = new ZigzagIterator(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 7), Arrays.asList(8, 9));

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

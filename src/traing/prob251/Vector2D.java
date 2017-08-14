package traing.prob251;

import java.util.*;

/**
 * Flatten 2D Vector
 * Link: https://leetcode.com/problems/flatten-2d-vector/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class Vector2D implements Iterator<Integer> {

    private ListIterator<List<Integer>> iterator;
    private ListIterator<Integer> subIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        this.iterator = vec2d.listIterator();
        if (this.iterator.hasNext()) {
            this.subIterator = this.iterator.next().listIterator();
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return this.subIterator.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (subIterator == null) return false;
        while (!this.subIterator.hasNext()) {
            if (!this.iterator.hasNext()) {
                return false;
            }
            this.subIterator = this.iterator.next().listIterator();
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> r1 = Arrays.asList(1, 2);
        List<Integer> r2 = Arrays.asList();
        List<Integer> r3 = Arrays.asList(4, 5, 6);
        List<Integer> r4 = Arrays.asList();

        List<List<Integer>> data1 = Arrays.asList(r1, r2, r3, r4);

        Vector2D v = new Vector2D(data1);

        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }
}

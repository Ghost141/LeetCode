package traing;

/**
 * The public common Random list node class.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) {
        this.label = x;
    }

    public RandomListNode(int x, RandomListNode next, RandomListNode rand) {
        this.label = x;
        this.next = next;
        this.random = rand;
    }

    @Override
    public String toString() {
        return "{" +
                "label=" + label +
                ", next=" + (next == null ? "null" : next.toString()) +
                ", random=" + (random == null ? "null" : random.toString()) +
                '}';
    }
}

package traing;

/**
 * Common List node for LeetCode problem
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return next == null ? String.valueOf(val) : String.valueOf(val) + "->" + next.toString();
    }
}

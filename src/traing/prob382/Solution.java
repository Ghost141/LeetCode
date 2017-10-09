package traing.prob382;

import traing.common.ListNode;

import java.util.Random;

/**
 * Linked List Random Node
 * Link: https://leetcode.com/problems/linked-list-random-node/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    private ListNode head;
    private int size = 0;
    private Random random = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = this.head;
        int ran = random.nextInt(size);
        while (ran-- > 0) node = node.next;
        return node.val;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        Solution s = new Solution(node);
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
        System.out.println(s.getRandom());
    }
}

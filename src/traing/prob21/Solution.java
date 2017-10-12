package traing.prob21;

import traing.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/12/17
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1), head = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        if (l1 != null) queue.offer(l1);
        if (l2 != null) queue.offer(l2);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                fake.next = node;
                head = node;
            } else {
                head.next = node;
                head = node;
            }
            if (node.next != null) queue.offer(node.next);
            node.next = null;
        }

        return fake.next;
    }
}

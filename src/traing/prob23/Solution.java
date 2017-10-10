package traing.prob23;

import traing.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k Sorted Lists
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode fakeHead = new ListNode(-1), head = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode node : lists) if (node != null) queue.offer(node);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = node;
                fakeHead.next = node;
            } else {
                head.next = node;
                head = node;
            }
            if (node.next != null) {
                queue.offer(node.next);
                node.next = null;
            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mergeKLists(new ListNode[] {
                new ListNode(1),
                null
        }));
    }
}
